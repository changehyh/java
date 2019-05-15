package com.changehyh.github.testdemo;

public interface IUtil2<R,P> {
     R compare(P p1,P p2);

    public static void main(String[] args) {

//        IUtil2<Integer,Integer> iUtil2 =(p1 ,p2)->{
//          return p1-p2;
//        };
//        Integer a = new Integer(10);
//        a.compareTo(new Integer(12));

        IUtil2<Integer,Integer> iUtil2 =Integer::compareTo;
        System.out.println(iUtil2.compare(10,10));
    }
}
