package com.changehyh.github.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args) {
        File file = new File("D:"+File.separator+"_test"+File.separator+"b"+File.separator+"writer.txt");
        File parent = file .getParentFile();
        if (!parent.exists()){
            boolean effect = parent.mkdirs();
            if (!effect){
                throw new RuntimeException("create directory" + parent.getParentFile());
            }
        }

        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.append("A").append("Hello World").append('\n');
            fileWriter.append("我爱你!！");
            fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
