package com.changehyh.github.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void write(){
        File file = new File(
                "D:"+File.separator+"test"
                        +File.separator+"b"+File.separator+"writer.txt");
        File parent = file.getParentFile();
        if (!parent.exists()){
            boolean effect = parent.mkdirs();
            if (!effect){
                throw new RuntimeException("create directory" + parent.getAbsolutePath());
            }
        }

        try(FileWriter writer = new FileWriter(file)){
            //String
            //char[]
            //--> char[] -> char(字符)
            writer.append("A").append("Hello World").append('\n');
            writer.write("I老虎U!！");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator
                + "test" + File.separator + "b" +
                File.separator + "writer.txt");
        try (FileReader reader = new FileReader(file)){
            char[] buff = new char[1024];
            int len = reader.read(buff);
            System.out.println("读了"+ len + "字符");
            System.out.println(new String(buff));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
