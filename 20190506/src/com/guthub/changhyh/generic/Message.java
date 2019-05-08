package com.guthub.changhyh.generic;

public class Message <T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message=" + message +
                '}';
    }
}
