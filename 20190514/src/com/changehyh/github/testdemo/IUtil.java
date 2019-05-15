package com.changehyh.github.testdemo;
@FunctionalInterface
public interface IUtil<P,R> {
    R switchPara(P p);

     static void main(String[] args) {
        IUtil<Integer,String> iUtil = String::valueOf;
        System.out.println(iUtil.switchPara(1000));

    }
}


