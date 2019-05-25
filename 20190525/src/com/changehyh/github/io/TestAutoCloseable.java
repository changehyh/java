package com.changehyh.github.io;


public class TestAutoCloseable {
    public static void main(String[] args) {
//        Message message = new Message();
//        try{
//            message.print();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try{
//                message.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        /**
        //JDK  try-with-resources
        try( 创建资源类的对象   ){

        }catch(){

        }
         */
        try(Message message = new Message()
        ){
            message.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Message implements AutoCloseable{

    public void print(){
        System.out.println("Message print方法调用");
    }
    @Override
    public void close() {
        System.out.println("Message close方法执行");
    }
}