package com.changehyh.github.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {

    public static void code1() {
        File file = new File("D:"+File.separator+"test"+File.separator+"Hello.java");
        try {
            boolean effect = file.createNewFile();
            if (effect){
                System.out.println("文件创建成功");
            }else {
                System.out.println("文件创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //文件删除与创建
    public static void code2() {
        //D:\\test\\javacode\\javase521
        File file = new File("D:"+File.separator+"test"+File.separator+"Hello.java");
        if (file.exists()){
            boolean effect = file.delete();
            if (effect){
                System.out.println("文件存在，并且删除成功");
            }else {
                System.out.println("文件存在，并且删除失败");
            }
        }else {
            try {
                boolean effect = file.createNewFile();
                if (effect){
                    System.out.println("文件不存在，创建成功");
                }else {
                    System.out.println("文件不存在，创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //创建目录
    public static void code3(){
        //D:\\test\\javacode\\javase521
        File directory = new File("D:" + File.separator + "test" + File.separator + "javacode" + File.separator + "javase521");
        if (directory.exists()){
            System.out.println("目录存在");
        }else {
            //directory.mkdirs(); //如果目录不存在，并且父目录也不存在，一并创建
            //directory.mkdir();//只会创建当前目录
            boolean effect = directory.mkdirs();
            if (effect){
                System.out.println("目录创建成功");
            }else {
                System.out.println("目录创建失败");
            }
        }
    }

    public static void code4() {
        //D:\\__test\\javacode\\javase521\\Hello.java
        File file = new File("D:" + File.separator +
                "test" + File.separator + "javacode" +
                File.separator + "javase521" + File.separator + "Hello.java");
        if (file.exists()) {
            System.out.println("Hello.java存在，不需要创建");
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                boolean effect = parentFile.mkdirs();
                if (effect) {
                    System.out.println(parentFile.getAbsolutePath() + "父目录不存在，创建成功");
                } else {
                    System.out.println(parentFile.getAbsolutePath() + "父目录不存在，创建失败");
                }
            }
            if (parentFile.exists()) {
                System.out.println(parentFile.getAbsolutePath() + "父目录存在");
                try {
                    boolean effect = file.createNewFile();
                    if (effect) {
                        System.out.println(file.getAbsolutePath() + "文件创建成功");
                    } else {
                        System.out.println(file.getAbsolutePath() + "文件创建失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void code5(){
        File file = new File("D:"+File.separator+"test"
                +File.separator+"javacode"
                +File.separator+"javase521"
                +File.separator+"Hello.java");
        System.out.println("文件名："+file.getName());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否是隐藏文件：" + file.isHidden());
        System.out.println("文件大小(字节)：" + file.length());
        //1970-01-01 00:00:00 -> now ms
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否能够执行：" + file.canExecute());//.exe .msi
    }
    public static void main(String[] args) {
        File file =  new File("D:"+File.separator+"test"
                +File.separator+"javacode"
                +File.separator+"javase521"
                +File.separator+"Hello.java");
        if (file.isDirectory()){
//            String[] files = file.list();
//            if (files != null) {
//                for (String f : files) {
//                    System.out.println(f);
//                }
//            }

//            String[] files = file.list((f, n) -> {
//                return n.endsWith("png");
//            });
//            if (files != null) {
//                for (String f : files) {
//                    System.out.println(f);
//                }
//            }
//
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
