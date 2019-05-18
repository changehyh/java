public class TestDemo1 {
    //最小倍数
    public static int smallestMultiple(int num){
        int product = num * (num-1);
        int m = 0;
        for (int i = 1; i <Integer.MAX_VALUE; i++) {
            m = product * i;
            for (int j = 2; j <= num; j++) {
                if (m % j !=0){
                    break;
                }
                if (j == num){
                    return m;
                }
            }
        }
        return m;
    }

    //第10001个素数
    public static int first10001_prime(int num){
        int i = 0;
        for (int j = 2; j < Integer.MAX_VALUE; j++) {
            if (isPrime(j)){
                i++;
                if (i==num)
                    return j;
            }
        }
        return -1;
    }

    private static boolean isPrime(long x) {
        if (x < 2){
            return false;
        }
        if (x==2){
            return true;
        }
        if ((x & 1)==0){
            return false;
        }
        final int max = (int) Math.sqrt(x);
        for (int i = 3; i <=max ; i+=2) {
            if ((x % i)==0){
                return false;
            }
        }
        return true;
    }

    //素数的和
    public static long Summation_prims(int num){
        long sum = 2;
        for (int i = 3; i < num; i += 2) {
            if (isPrime1(i)){
                sum += i;
            }
        }return sum;
    }

    private static boolean isPrime1(long x) {
        final  int max = (int) Math.sqrt(x);
        for (int i = 3; i <=max ; i+= 2) {
            if ((x % i)==0){
                return false;
            }
        }
        return true;
    }

    //
    public static void main(String[] args) {
//        System.out.println(smallestMultiple(20));
//        System.out.println(first10001_prime(10001));
        System.out.println(Summation_prims(20000));
    }
}
