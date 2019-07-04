package com.github.changehyh;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        String B = scanner1.nextLine();
        int count = 0 ;
        for (int i = 0;i<=A.length();i++){
            StringBuilder sb = new StringBuilder(A);
            StringBuilder str = sb.insert(i,B);
            String s1 = str.toString();
            StringBuilder str1 = str.reverse();
            String s2 = str1.toString();
            if (s1.equals(s2)){
                count++;
            }
        }
        System.out.println(count);
    }
}


