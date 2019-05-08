package com.guthub.changhyh.generic;

public class Point1 <T>{
    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private T x;
    private T y;

}
