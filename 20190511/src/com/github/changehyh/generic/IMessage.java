package com.github.changehyh.generic;

import com.github.changehyh.inter.Message;

import javax.swing.*;
import java.util.InputMismatchException;

//泛型接口
//泛型除了可以定义在类中，也可以定义在接⼝⾥面
public interface IMessage<T> {

    void greeting(T t);

    String computer (T t , int count);

    public static void main(String[] args) {
        //第一个
        IMessage<String> iMessage = new QQMessage();
        iMessage.greeting("hello world");
        //第二个
        IMessage<Integer> message = new MyMessage<>();
        message.greeting(10);

        IMessage<StringBuffer> message1 = new MyMessage<>();
        message1.greeting(new StringBuffer("Hello StringBuffer"));
    }
}
//第一个： 泛型接口的子类（实现类）直接明确了类型参数的具体类型
class QQMessage implements IMessage<String> {

    @Override
    public void greeting(String s) {
        System.out.println("QQ" + s);
    }

    @Override
    public String computer(String ss, int count) {
        return null;
    }
}
//第二个：泛型接口的子类定义成泛型类
class MyMessage<T> implements IMessage<T>{

    @Override
    public void greeting(T t) {
        System.out.println(t);
    }

    @Override
    public String computer(T t, int count) {
        return null;
    }
}


