package com.hyh.service;

import com.hyh.dao.AccountDao;
import com.hyh.vo.Account;

import java.util.List;

public class AccountService {
    private AccountDao accountDao;


    public AccountService() {
        this.accountDao = new AccountDao();
    }

    public Account login(String username,String password){
        return this.accountDao.login(username,password);
    }
    public boolean register(Account account){
        return this.accountDao.register(account);
    }

    public List<Account> queryAllAccount(){
        return this.accountDao.queryAccount();
    }

}
