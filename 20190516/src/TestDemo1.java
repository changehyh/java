public class TestDemo1 {


    //最大质因数
    public static long primeFactors(long number) {
        if (number == 1)
            return 1;

        for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    return primeFactors(number / i);
        }
        return number;
    }

    //最大回文乘积
    public static int bigPalindrome(){
        int num = 0;
        for (int i = 999; i >0; i--) {
            for (int j = 999; j >0; j--) {
                int product =i*j;
                if (product > num && bigPalindrome(product))
                    num = product;
            }
        }
        return num;
    }
    private static boolean bigPalindrome(int product) {
        int bitCount = 0;
        int bit[] = new int[10];
        while (product!=0){
            bit[bitCount++] = product % 10;
            product /= 10;
        }
        for (int i = 0; i <bitCount >>1; i++) {
            if (bit[i] != bit[bitCount-i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primeFactors(603032425L));
        System.out.println(bigPalindrome());
    }
}
