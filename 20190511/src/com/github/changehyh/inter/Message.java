package com.github.changehyh.inter;

public interface Message {
    //接口中定义普通方法 通过对象方法
    default  String company(){
        return "未知";
    }
    //静态方法
    static void printInfo(){
        System.out.println("这是接口的静态方法");
    }

    void print();
}
class QQMessage implements Message{
    @Override
    public void print() {
        System.out.println("这是QQMessage");
    }

    @Override
    public String company() {
        return "腾讯";
    }
}
class WechatMessage implements Message{

    @Override
    public void print() {
        System.out.println("微信Message");
    }

    @Override
    public String company() {
        return "腾讯";
    }
}
class NsnMessage implements Message{

    @Override
    public void print() {
        System.out.println("Msn的Message");
    }
    @Override
    public String company() {
        return "微软";
    }
}