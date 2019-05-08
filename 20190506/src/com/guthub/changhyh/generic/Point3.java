package com.guthub.changhyh.generic;

public class Point3<T> {
    private T x;
    private T y;
    //泛型方法
    public <T> void printPoint(T t){
        System.out.println(t);
    }
    public <T ,E> void  printPoint(T t,E e){
        //处理业务
        System.out.println(t);
        System.out.println(e);
    }
    @Override
    public String toString() {
        return "Point3{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {

        return x;
    }

    public T getY() {
        return y;
    }
}
