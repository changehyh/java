package com.guthub.changhyh.generic;

public class TestPoint3 {
    public static void main(String[] args) {

        Point3 point3 = new Point3();
        Point2<Integer, Double> point2 = new Point2<>();
        point2.setX(10);
        point2.setY(10.2D);
        //T --> Point
        point3.printPoint(point2);
        point3.printPoint("hello world",20);
    }
}
