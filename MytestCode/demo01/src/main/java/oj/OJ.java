package oj;

public class OJ {
    //给定一个字符串，找到没有重复字符的最长子串，返回它的长度。



    // 统计字符串中数字个数
    //Character.isDigit 直接判断指定字符是否为数字
    public static int isNumber1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //将一个数组从左开始第几位之前的进行旋转：左旋数组
    //如：将"abcdef"第2位之前(a为0号位置)进行旋转----》"cdefab"
    public static void leftRotateString(String str,int n){
        char[] data = str.toCharArray();
        char[] chars = new char[data.length];

        int count = 0;
        for (int i = n; i < data.length; i++) {
            chars[count] = data[i];
            count++;
        }

        for (int j =0;j<n;j++){
            chars[count] = data[j];
            count++;
        }

        String string = new String(chars);
        System.out.println(string);
    }

    public static void main(String[] args) {
        String s = "abc102caf";
        leftRotateString(s,3);
    }
}
