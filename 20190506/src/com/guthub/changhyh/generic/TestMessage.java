package com.guthub.changhyh.generic;

public class TestMessage {
    //Message泛型类的类型参数的具体类型 String
    public static void fun(Message<String>message){
        System.out.println(message.getMessage());
    }
    //fun方法接收的Message对象的类型参数具体类型是任意类型
    public static void fun2(Message<?>message){
        //message.setMessage(111);
        // 此时使⽤用通配符"?"描述的是它可以接收任意类型，
        // 但是由于不不确定类型，所以⽆无法修改
        System.out.println(message.getMessage());
    }
    public static void main(String[] args) {
        Message<String> message = new Message<>();
        message.setMessage("I AM BEST");
        fun(message);
        Message<Integer> message1 = new Message<>();
        message1.setMessage(999);
        fun2(message1);
    }
}
