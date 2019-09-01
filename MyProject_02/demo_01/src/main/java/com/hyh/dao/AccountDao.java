package com.hyh.dao;

import com.hyh.common.AccountStatus;
import com.hyh.common.AccountTyp;
import com.hyh.vo.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends BaseDao{

    public Account login(String username,String password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Account account = null;
        try{
            connection = this.getConnection(true);
            String str = "select id,username,password,name,account_type,account_status from account where username=? and password=?";
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                account = this.extractAccount(resultSet);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return account;
    }

    private Account extractAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();

        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setName(resultSet.getString("name"));
        account.setAccountTyp(AccountTyp.valueOf(resultSet.getInt("account_type")));
        account.setAccountStatus(AccountStatus.valueOf(resultSet.getInt("account_status")));

        return account;
    }
    public List<Account> queryAccount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Account> accountList = new ArrayList<>();
        try {
            connection = this.getConnection(true);
            String sql = "select id, username, password, name, account_type, account_status from account";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accountList.add(this.extractAccount(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource(resultSet, statement, connection);
        }
        return accountList;
    }

    public boolean register(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String str = "insert into account(username,password,name,account_type,account_status) " +
                    "values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2, DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getAccountTyp().getFlg());
            preparedStatement.setInt(5,account.getAccountStatus().getFlg());

            effect = (preparedStatement.executeUpdate() == 1);
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                Integer id = resultSet.getInt(1);
                account.setId(id);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
}
