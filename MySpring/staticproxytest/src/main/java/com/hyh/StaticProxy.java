package com.hyh;

public class StaticProxy implements IUserManager{

    //对真实对象的引用
    private IUserManager iUserManager;
    public StaticProxy(IUserManager iUserManager){
        this.iUserManager = iUserManager;
    }

    public boolean addUser(String username, String password) throws Exception {
        System.out.println("========StaticProxy.addUser()=======");
        return false;
    }

    public boolean delUser(int id) throws Exception {
        System.out.println("========StaticProxy.delUser()=======");
        return false;
    }

    public boolean modifyUser(int id, String username,String password) throws Exception {
        System.out.println("========StaticProxy.modifyUser()=======");
        return false;
    }

    public void queryUser(int id) throws Exception {
        System.out.println("========StaticProxy.queryUser()=======");
    }
}
