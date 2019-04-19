//快乐数
public class TestDemo1 {
    //判读那各个位上的平方和
    //125%10=5  125/10=12  12%10=2  12/10=1  1%10=1
    public static int function(int num){
        int set=0;
        while (num!=0){
           set=set+(num%10)*(num%10);
            num=num/10;
        }return set;
    }
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
            while (n != 1) {
                n = function(n);
                if (n == 4) {
                    return false;
                }
            }return true;
        }
        //输出首次出现三次的英文字母
    public static char function1(String str){
        int[]hash=new int[256];
        char[]chars=str.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            char ch=chars[i];
            if (ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                hash[ch]++;//地址内的值进行+1；
                if (hash[ch]==3){
                    return ch;
                }
            }
        }return '0';
    }
    //"杀人游戏"
    public static int function2(int n){
        //数数
        int[]array=new int[n];
        for (int i = 0; i <array.length ; i++) {
            array[i]=1;//每次初始化从1开始
        }
        int count=0;
        int num=n;
        while (num>1){
            for (int i = 0; i <n; i++) {
                if (array[i]==1){
                    count++;
                    if (count==3){
                        array[i]=0;
                        num--;
                        count=0;
                    }
                }

            }
        }
        for (int i = 0; i <n; i++) {
            if (array[i]==1){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(function2(0));
        //System.out.println(function1("abcbdc"));
        //System.out.println(isHappy(19));
    }
}