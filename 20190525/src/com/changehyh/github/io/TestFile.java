package com.changehyh.github.io;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File directory = new File("D:"+File.separator+"test");
        int level = 0;
        printDirectory(level,directory);
    }

    private static void printDirectory(int level, File file) {
        if (file.isFile()){
            System.out.println(space(level)+file.getName());
        }else {
            if (file.isDirectory()) {
                System.out.println(line(level)+file.getName());
            }
            File[] files = file.listFiles();
            if (files != null){
                for (File f :files){
                    printDirectory(level+2,f);
                }
            }
        }
    }

    private static String space(int level) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < level;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    public  static  String line(int level){
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i <level-i;i++){
            sb.append("|__");
        }
        return sb.toString();
    }
}
