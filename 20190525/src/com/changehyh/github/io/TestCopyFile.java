package com.changehyh.github.io;

import java.io.*;

public class TestCopyFile {

    //cp srcFile   destDirectory
    public static void main(String[] args) {
        File srcFile = new File("D:"+File.separator+
                "test"+File.separator+"a"+File.separator+"Hello.text");
        File destFile = new File("D:"+File.separator
                +"test"+File.separator+"b", srcFile.getName());
        if (!srcFile.exists()){
           throw new IllegalArgumentException("srcFile must not be null or exists");
        }
        if (!destFile.getParentFile().exists()){
            destFile.getParentFile().mkdirs();
        }
        try (FileInputStream InputStream = new FileInputStream(srcFile);
             FileOutputStream outputStream = new FileOutputStream(destFile)
        ){
            byte [] buff = new byte[5];
            int len = -1;
            while ((len = InputStream.read(buff))!= -1){
                outputStream.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
