package com.changehyh.github.io;

import java.io.*;

public class TestMerge {
    public static void main(String[] ages) {
        File srcFile = new File("D:"
                +File.separator+"_test"+File.separator+"scr.txt");
        File destFile = new File("D:"
                +File.separator+"_test"+File.separator+"dest.txt");
        try {
            srcFile.createNewFile();
            destFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileInputStream scr = new FileInputStream(srcFile);
            FileOutputStream dest = new FileOutputStream(destFile);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ){
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = scr.read(buff))!= -1){
                outputStream.write(buff,0,len);
            }
        
            byte[] bytes = outputStream.toByteArray();
            dest.write(bytes);
            dest.flush();

//            byte[] bytes1 = new byte[5];
//            int len1 = -1;
//            while ((len = scr.read(bytes1))!= -1){
//                dest.write(bytes1,0,len1);
//            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
