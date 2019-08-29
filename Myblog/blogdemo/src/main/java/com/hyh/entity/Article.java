package com.hyh.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
public class Article {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private String userAccout;

    private Date createTime;

}
