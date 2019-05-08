package com.guthub.changhyh.generic;

public class Point2 <T ,E>{
    private T x;
    private E y;
    //定义具体的类型的属性

    public void setX(T x) {
        this.x = x;
    }

    public void setY(E y) {
        this.y = y;
    }

    public T getX() {

        return x;
    }

    public E getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
