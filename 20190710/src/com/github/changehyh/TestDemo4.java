package com.github.changehyh;

import java.util.*;

public class TestDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            n /= 5;
            count += n;
        }
        System.out.println(count);
    }
}
