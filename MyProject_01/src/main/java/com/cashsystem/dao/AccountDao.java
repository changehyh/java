package com.cashsystem.dao;

import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class AccountDao extends BaseDao{

    //操作数据库
    public Account login(String username , String password){
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句

        Account account = null;

        try{
            //拿到连接
            connection = this.getConnection(true);
            String strSql = "select id,username,password,name,account_type,account_status from account where username=? and password=?";
            preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));

            resultSet = preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (resultSet.next()){
                //解析resultSet，拿到对应的account
                account = this.extractAccount(resultSet);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return account;
    }

    private Account extractAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();

        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setName(resultSet.getString("name"));
        account.setAccountType(AccountType.valueOf(resultSet.getInt("account_type")));
        account.setAccountStatus(AccountStatus.valueOf(resultSet.getInt("account_status")));

        return account;
    }


    public boolean register(Account account){
        Connection connection = null;//连接数据可
        ResultSet resultSet = null;//
        PreparedStatement preparedStatement = null;//预处理你的sql语句
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String strSql = "insert into account(username,password,name,account_type,account_status) " +
                    "values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getAccountType().getFlg());
            preparedStatement.setInt(5,account.getAccountStatus().getFlg());

            effect = (preparedStatement.executeUpdate() == 1);
            //获取自增的主键
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                account.setId(id);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
}
