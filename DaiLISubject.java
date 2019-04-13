package com.bit.src;

public class DaiLISubject implements ISubject {
    private RealSubject realSubject;//真实的业务
    public DaiLISubject(RealSubject realSubject){
        this.realSubject=realSubject;
    }
    public void produceComputer(){
        System.out.println("1,生产电脑");
    }
    public void afterSale(){
        System.out.println("3,售后服务");
    }
    @Override
    public void buyComputer() {
        this.produceComputer();//真是操作前准备
        this.realSubject.buyComputer();//调用代理业务
        this.afterSale();//操作后结尾
    }

    @Override
    public void printComputer() {
        System.out.println("MAC电脑");
    }
}
