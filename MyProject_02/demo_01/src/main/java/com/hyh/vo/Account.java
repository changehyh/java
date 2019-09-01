package com.hyh.vo;

import com.hyh.common.AccountStatus;
import com.hyh.common.AccountTyp;
import lombok.Data;


@Data
public class Account {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private AccountTyp accountTyp;

    private AccountStatus accountStatus;
}