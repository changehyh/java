package com.github.changehyh.test;
import java.util.Scanner;

public class TestDemo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            if (N == 0) {
                return;
            }
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            int T = scan.nextInt();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (T == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
