package com.hyh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.entity.Article;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    @Test
    public void testJackson(){
        List<Article> articleList = new ArrayList<>();
        Article article1 = new Article();
        article1.setUserId(1);
        article1.setTitle("我的博客");
        article1.setContent("内容1");
        article1.setCreateTime(new Date());
        articleList.add(article1);
        Article article2 = new Article();
        article2.setUserId(2);
        article2.setTitle("我的博客2");
        article2.setContent("内容2");
        article2.setCreateTime(new Date());
        articleList.add(article2);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            String str = objectMapper.writeValueAsString(articleList);
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
