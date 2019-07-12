package com.github.changehyh;

import java.util.*;

public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int num = 2;
        int x = 1;
        while (num<=n && num <=m){
            if (n % num ==0 && m %num ==0){
                x = num;
            }
            num ++;
        }
        System.out.println(n*m/x);
    }
}
