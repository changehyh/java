import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(buy(a));
    }
    public static int buy(int in) {
        int a= in;
        if (a%2 != 0  || a < 6 || a ==10){
            return -1;
        }else if(a%8 == 0){
                return a/8;
        }
        return a/8 +1;
    }
}
