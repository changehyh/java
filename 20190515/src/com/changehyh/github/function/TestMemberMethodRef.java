package com.changehyh.github.function;

//引用对像方法

public class TestMemberMethodRef {
    public static void main(String[] args) {
//        IUtil2<String> iUtil2 = new IUtil2<String>() {
//            @Override
//            public String switchPara() {
//                return "hello world".toUpperCase();
//            }
//        };
//        System.out.println(iUtil2.switchPara());

        //String 成员方法 toUpperCase()
        IUtil2<String> iUtil21 = "hello world"::toUpperCase;
        System.out.println(iUtil21.switchPara());
    }
}
@FunctionalInterface
interface IUtil2<R>{
    R switchPara();
}