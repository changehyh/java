package com.guthub.changhyh.generic;

public class TestPoint1 {
    public static void main(String[] args) {
        Point1<Integer> intPoint1 = new Point1<>();
        intPoint1.setX(10);
        intPoint1.setY(20);
        int x = (Integer) intPoint1.getX();
        int y = (Integer) intPoint1.getY();
        System.out.println(x + " " + y);
        Point1<String> strPoint1 = new Point1<>();
        strPoint1.setX("东经120度");
        strPoint1.setY("北纬20度");
        System.out.println(strPoint1.getX()+ " " +strPoint1.getY());

    }
}
