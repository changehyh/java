package com.hyh.servlet;

import com.hyh.entity.Article;
import com.hyh.entity.User;
import com.hyh.exception.ParameterException;
import com.hyh.util.BaseDao;
import com.hyh.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleListServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> articleList = new ArrayList<>();
        //处理前端请求数据
        String sid = req.getParameter("id");
        Integer id = null;
        try{
            id = Integer.parseInt(sid);
        }catch (Exception e){
            throw new ParameterException("id错误  ("+sid+")");
        }

        //处理业务及数据库操作
        try {
            connection = BaseDao.getConnection();
            String sql = "select a.id,a.title,a.content,a.create_time\n" +
                    "from article a join user u on a.user_id = u.id where u.id=?";

            preparedStatement = connection.prepareStatement(sql);
            //TODO 处理前端异常
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
//              article.setUserId(resultSet.getInt("user_id"));
                article.setCreateTime(resultSet.getTimestamp("create_time"));
                articleList.add(article);
            }
        }finally {
//            if (resultSet !=null){
//                resultSet.close();
//            }
//            if (preparedStatement !=null){
//                preparedStatement.close();
//            }
//            if (connection !=null){
//                connection.close();
//            }
            BaseDao.close(connection,preparedStatement,resultSet);
        }
        return articleList;
    }
}
