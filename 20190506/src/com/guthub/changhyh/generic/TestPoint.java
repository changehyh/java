package com.guthub.changhyh.generic;

public class TestPoint {
    public static void main(String[] args) {
        {
            Point intPoint = new Point();
            intPoint.setX(10);//int
            intPoint.setY(20);
            int x = (int) intPoint.getX();
            int y = (int) intPoint.getY();
            System.out.println("Point(x,y)=(" + x + "," + y + ")");
        }
        {
            //设置数据
            Point intPoint1 = new Point();
            intPoint1.setX(10.2);
            intPoint1.setY("北纬30度");
            //取出数据
            String x = (String) intPoint1.getX();
            String y = (String) intPoint1.getY();
            System.out.println("(" +x+","+y + ")");
        }
    }
}
