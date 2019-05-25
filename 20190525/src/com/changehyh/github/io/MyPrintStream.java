package com.changehyh.github.io;

import java.io.*;

/**
 * OutputStream
 * write(int b)
 * write(byte[] b)
 * 解决
 * write(int value)
 * write(String value)
 * write(double value)
 */
public class MyPrintStream {
    private OutputStream out;
    public MyPrintStream(OutputStream out){
        this.out = out;
    }

    public void write(int value){
        this.write(String.valueOf(value));
    }
    public void write(double value){
        this.write(String.valueOf(value));
    }

    public void flush(){
        try {
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(String value) {
        byte [] data = value.getBytes();
        try {
            this.out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (
                OutputStream out = new FileOutputStream(
                "D:"+ File.separator+"test"+File.separator+"myprint.txt"
                )
        ){
            MyPrintStream myPrintStream = new MyPrintStream(out);
            myPrintStream.write(65);
            myPrintStream.write(10.5);
            myPrintStream.write("HelloWorld");
            myPrintStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
