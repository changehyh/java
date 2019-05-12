package com.github.changehyh.inter;

public class TestMessage {
    public static void main(String[] args) {
        Message qqMessage= new QQMessage();
        Message wechatMessage = new WechatMessage();
        Message msnMessage = new NsnMessage();

        qqMessage.print();
        System.out.println(qqMessage.company());

        wechatMessage.print();
        System.out.println(wechatMessage.company());

        msnMessage.print();
        System.out.println(msnMessage.company());

        Message.printInfo();
    }
}
