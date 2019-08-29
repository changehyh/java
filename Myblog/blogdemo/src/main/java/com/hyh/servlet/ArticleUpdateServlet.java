package com.hyh.servlet;

import com.hyh.entity.Article;
import com.hyh.exception.BusinessException;
import com.hyh.util.BaseDao;
import com.hyh.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //处理前端请求数据

        //application/json数据需要使用request。getInputStream()来获取
        //获取JSON类型的请求
        Article article = JSONUtil.get(req,Article.class);

        try {
            connection = BaseDao.getConnection();
            String sql ="update article set title=?,content=? where id=?";

            preparedStatement = connection.prepareStatement(sql);
            //TODO 处理前端异常
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getId());

            int r = preparedStatement.executeUpdate();
            if (r > 0){
                return r;
            }else {
                throw new BusinessException("没有该文章" + article.getId());
            }
        }finally {
            BaseDao.close(connection,preparedStatement,null);
        }
    }
}
