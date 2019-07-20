package com.github.changehyh;

import java.util.*;

public class TestDemo1 {
    public static int[] exchangeAB(int[] AB) {
    // write code here
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] A = {1,3,4,1,4};
        System.out.println(Arrays.toString(exchangeAB(A)));
    }

}
