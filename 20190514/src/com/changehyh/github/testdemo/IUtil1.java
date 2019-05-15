package com.changehyh.github.testdemo;
@FunctionalInterface
// 引用对象⽅法
public interface IUtil1<R> {
     R switchPara();


    public static void main(String[] args) {
        IUtil1<String> iUtil1 = "HELLO"::toLowerCase;
        System.out.println(iUtil1.switchPara());
    }
}
