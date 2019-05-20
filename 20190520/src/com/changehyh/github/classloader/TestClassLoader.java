package com.changehyh.github.classloader;

public class TestClassLoader {
    public static void main(String[] args) {
        Class memberCls = Member.class;
        //获取ClassLoader
        //AppClassLoader(应用程序类加载器)
        System.out.println(memberCls.getClassLoader());
        //ExtClassLoader(扩展类加载器)
        System.out.println(memberCls.getClassLoader()
                .getParent());
        //null ->Bootstrap(启动类加载器) ClassLoader
        System.out.println(memberCls.getClassLoader()
        .getParent().getParent());
    }
}

//1. com.changehyh.github.classloader
//2. com.changehyh.github.classloader.Member
//3. %classpath%/com/changehyh/github/classloader/Member.class
//4. Member.class对象
class Member{

}
