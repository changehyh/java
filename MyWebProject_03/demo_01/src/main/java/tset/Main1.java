package tset;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int a = add(num);
            int b = add(num * num);
            System.out.println(a + " " + b);
        }
    }

    private static int add(int i) {
        int count = 0;
        while (i != 0){
            count += i%10;
            i /= 10;
        }
        return count;
    }
}
