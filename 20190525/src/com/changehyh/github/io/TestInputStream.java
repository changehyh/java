package com.changehyh.github.io;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) {
        File file = new File("D:"+
                File.separator+"test"+File.separator+"Hello.text");
        try(FileInputStream inputStream = new FileInputStream(file)) {
//            int value = -1;
//            while ((value = inputStream.read())!=-1){
//                System.out.print(value);
//            }

            //buffer :
            //1024   1 2 4  1024
            byte[] buff = new byte[5];
            inputStream.read(buff);
            inputStream.read(buff,2,2);
            System.out.println(new String(buff));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
