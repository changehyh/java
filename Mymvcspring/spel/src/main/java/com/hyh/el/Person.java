package com.hyh.el;

import com.hyh.el.Car;

public class Person {
    private String pName;

    private Car car;

    private String city;

    private String Info;

    public Person(){

    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pName='" + pName + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", Info='" + Info + '\'' +
                '}';
    }
}
