public class TestDemo3 {
//    public static void reverse(char[] str, int left, int right){
//        while (left<right){
//            char temp=str[left];
//            str[left]=str[right];
//            str[right]=temp;
//            left++;
//            right--;
//        }
//    }
//    public static String stringCompress(String str){
//        char[]chars=str.toCharArray();
//        reverse(chars,0,str.length()-1);
//        int i=0;
//        int j=0;
//        while (i<chars.length){
//            if (chars[i]==' '){
//                i++;
//                j++;
//            }else if (j==str.length()||chars[j]==' '){
//                reverse(chars,i,--j);
//                i = ++j;
//            }else {
//                j++;
//            }
//        }
//        return String.copyValueOf(chars);
//    }
    public static String reverse2(String str, int left, int right){
        char[]chars=str.toCharArray();
        while (left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return String.copyValueOf(chars);
    }

    public static void leftRotateString(String str,int n) {
        int index1=0;
        int index2=n-1;
        int index3=n;
        int index4=str.length()-1;
        str=reverse2(str,index1,index2);
        str=reverse2(str,index3,index4);
        str=reverse2(str,index1,index4);
        System.out.println(str);
    }
    public static void main(String[] args) {
        leftRotateString("abcdef",2);
    }
}