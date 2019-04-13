package com.bit.src;

public class RealSubject implements ISubject{

    @Override
    public void buyComputer() {
        System.out.println("2,买电脑");
    }

    @Override
    public void printComputer() {
        System.out.println("MAC电脑");
    }
}
