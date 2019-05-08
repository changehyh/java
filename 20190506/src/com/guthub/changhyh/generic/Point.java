package com.guthub.changhyh.generic;

public class Point {
    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public void setY(Object y) {
        this.y = y;
    }

    private Object x;
    private Object y;

    @Override
    public String toString() {
        return "point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
