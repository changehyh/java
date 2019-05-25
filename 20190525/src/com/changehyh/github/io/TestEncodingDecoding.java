package com.changehyh.github.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestEncodingDecoding {
    public  static void tist1(){
        System.getProperties().list(System.out);
        String str = System.clearProperty("user.home");
        System.out.println(str);
        //C:\Users\asus
        //home/zhangsan
        //  /home/lisi
        //  多用户操作系统
    }

    public static void main(String[] args) {

        try(OutputStream out = new FileOutputStream("D:"
                +File.separator +"test"+ File.separator+"encoding.txt"
        )){
            //out.write("比特科技".getBytes("ISO_8859_1"));
            out.write("比特科技".getBytes(StandardCharsets.ISO_8859_1));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
