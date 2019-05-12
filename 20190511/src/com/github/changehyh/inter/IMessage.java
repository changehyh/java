package com.github.changehyh.inter;


@FunctionalInterface// 是⼀个函数式编程接⼝，只允许有⼀个方法
public interface IMessage {

    void print();// 这是⼀个接⼝，接⼝中的抽象方法必须由⼦类覆写。


    public static void main(String[] args) {
//        内部类
//         IMessage接口的匿名内部类的实例化对象
//        IMessage iMessage = new IMessage() {
//            @Override
//            public void print() {
//                System.out.println("hello");
//            }
//        };
//        iMessage.print();



//        Lambda表达式
//        IMessage iMessage = () -> System.out.println("hello");
//        iMessage.print();

        //接口 -> 面向对象的
        //函数接口--> 面向对象 函数编程
        //Lambda表达式（函数）--> 函数编程

        //函数编程
        IMessage iMessage = () ->{
            System.out.println("hello java");
            System.out.println("hello c++");
            System.out.println("hello ");
        };
        iMessage.print();

        IMessage1 iMessage1 = (a, b) -> a + b;
        int sum =iMessage1.sum(1,2);
        System.out.println(sum);
    }
}
@FunctionalInterface// 是⼀个函数式编程接⼝，只允许有⼀个方法
interface IMessage1{
    int sum (int a,int b);
}