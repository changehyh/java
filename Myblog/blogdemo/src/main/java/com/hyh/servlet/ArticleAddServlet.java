package com.hyh.servlet;

import com.hyh.entity.Article;
import com.hyh.exception.BusinessException;
import com.hyh.exception.ParameterException;
import com.hyh.util.BaseDao;
import com.hyh.util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleAddServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //处理前端请求数据
        //application/json数据需要使用request。getInputStream()来获取
//        String userAccount = req.getParameter("userAccount");
//        String title = req.getParameter("title");
//        String content = req.getParameter("content");
        //获取JSON类型的请求
        Article article = JSONUtil.get(req,Article.class);

        try {
            connection = BaseDao.getConnection();
            String sql = "insert into article(title, content,user_id,create_time)\n " +
                    "select ?,?,user.id,now() from user\n " +
                    "where user.name=?;";

            preparedStatement = connection.prepareStatement(sql);
            //TODO 处理前端异常
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setString(3,article.getUserAccout());

            int r = preparedStatement.executeUpdate();
            if (r > 0){
                return r;
            }else {
                throw new BusinessException("没有该用户" + article.getContent());
            }
        }finally {
            BaseDao.close(connection,preparedStatement,null);
        }
    }
}
