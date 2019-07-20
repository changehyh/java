package com.github.changehyh.test;

import java.util.*;

public class TestDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(addAB(A,B));
    }

    public static int addAB(int A, int B) {
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        int sum = A ^ B;
        int num = (A & B) << 1;
        return addAB(sum, num);
    }
}
