package com.github.changehyh.generic;

import com.github.changehyh.inter.Message;

/**
 *    泛型上限
 * 1、应用到泛型类
 * 2. 应用到方法参数上
 */
public class Message1 <T extends Number>{

    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message1{" +
                "message=" + message +
                '}';
    }

    //泛型上限
    public void print (Message1<? extends Integer>message){
        System.out.println(message.getMessage());
    }

    public static void main(String[] args) {
//       Message1<Integer> message1 = new Message1<>();
//       message1.setMessage(10);
//        System.out.println(message1.getMessage());

        Message1<Number> message1 = new Message1<>();
        message1.setMessage(10); // 10 -> Integer -> Number
        System.out.println(message1.getMessage());

        // error 错误
//        Message1<Boolean> message1 = new Message1<>();
//        message1.setMessage(false);
//        System.out.println(message1.getMessage());


    }
}
