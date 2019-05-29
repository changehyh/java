package com.changehyh.github.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanner {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出生日：");
        //2019-05-25
        //4-2-2
        //\d -> 0-9
        //{4} -> 出现的次数
        //\d{4}-\d{2}-\d{2}
        //[1-9][0-9]{4,}
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String birthday = scanner.next();
            System.out.println(birthday);
        }else {
            System.out.println("生日格式输入错误");
        }
        scanner.close();

//        System.out.println("从键盘读取数据");
//        if (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }

//        System.out.println("请输入年龄：");
//        if (scanner.hasNextInt()) {
//            System.out.println(scanner.nextInt());
//        } else {
//            System.out.println("输入的内容不是整数");
//        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("D:"+File.separator+"_test"+File.separator+"java.txt"));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
