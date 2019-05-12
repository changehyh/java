package com.github.changehyh.generic;

import com.github.changehyh.inter.Message;

public class Message2 <T>{

    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message2{" +
                "message=" + message +
                '}';
    }

    //泛型下限只能⽤在⽅法参数，可以修改内容。
    //表示只能够设置String及其父类Object
    public static void print(Message2<? super String>message2){
//        message2.setMessage(new Integer(20)); 错误
        message2.setMessage("Hello World");
        System.out.println(message2.getMessage());
    }

    public static void main(String[] args) {
        Message2<String> message2 = new Message2<>();
        message2.setMessage("hello bit");
        print(message2);

        //错误
//        Message2<StringBuffer> message3 = new Message2<>();
//        message2.setMessage(new StringBuffer("hello bit"));
//        print(message2);
    }
}
