package com.changehyh.github.io;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) {
        File file = new File("D:"+File.separator+ "text"
                +File.separator+"a"+File.separator+"Hello.text");
        //判断根目录是否存在
        File parent = file.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        //输出流：目录存在，文件不存在，创建
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            outputStream.write(65);//int ascii 65 ->A
            outputStream.write(66);
            String str = "I老虎U!！";
            byte[] strBytes = str.getBytes();
            outputStream.write(strBytes);
            outputStream.write('\n');
            outputStream.write(49);
            outputStream.write(50);
            outputStream.write(97);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!= null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main1(String[] args) {

        File file = new File("D:"+File.separator+"test"
                +File.separator+"a"+File.separator+"Hello.text");
             //判断目录是否存在
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }

        //输出流： 目录存在，文件不存在，创建
        try (FileOutputStream OutputStream = new FileOutputStream(file)){
            OutputStream.write(65);
            OutputStream.write(66);
            String str = "I老虎U!！";
            byte[] strBytes = str.getBytes();
            OutputStream.write(strBytes);
            OutputStream.write('\n');
            OutputStream.write(49);
            OutputStream.write(50);
            OutputStream.write(97);
            OutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
