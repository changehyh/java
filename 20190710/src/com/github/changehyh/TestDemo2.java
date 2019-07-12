package com.github.changehyh;

import java.util.Scanner;

public class TestDemo2 {
    public static int init(int W,int H){
        if (W ==1){
            return H;
        }
        //TODO
        return W;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int H = scanner.nextInt();
        System.out.println(init(W,H));
    }
}
