package com.hyh.common;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum AccountTyp {
    ADMIN(1,"管理员"),CUSTOMER(2,"普通用户");

    private int flg;
    private String desc;

    AccountTyp(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    public static AccountTyp valueOf(int flg){
        for (AccountTyp accountTyp : values()){
            if(accountTyp.flg==flg){
                return accountTyp;
            }
        }
        throw new RuntimeException("accountStatus flg"
                + flg + "not fount!");
    }
}
