package com.github.changehyh;

import java.util.*;
public class TestDemo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        String str = "";

        while (n != 0){
            int s1 = n%10;
            int s2 = n/10;
            str = str + String.valueOf(s1);
            i++;
            n = s2;
        }
        System.out.println(str);
    }
}
