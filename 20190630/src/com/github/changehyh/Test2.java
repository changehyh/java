package com.github.changehyh;

import org.omg.CORBA.portable.InputStream;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        Scanner scanner1  = new Scanner(System.in);
        String str = scanner.nextLine();
        String [] arr = str.split(",");
        System.out.println(Arrays.toString(arr));

        //int K = scanner1.nextInt();
        //System.out.println(findKth(array,array.length,K));
    }

        public static int findKth ( int[] a, int n, int K){
            return quickSocrt(a, 0, n - 1, K);
        }
        public static int quickSocrt ( int[] arr, int low, int high, int K){
            int i = partion(arr, low, high);
            if (K == i - low + 1) {
                return arr[i];
            } else if (i - low + 1 > K) {
                return quickSocrt(arr, low, i - 1, K);
            } else {
                return quickSocrt(arr, i + 1, high, K - (i - low + 1));
            }
        }
        public static int partion ( int[] array, int low, int high){
            int temp = array[low];
            while (low < high) {
                while (low < high && array[high] >= temp) {
                    high--;
                }
                if (low >= high) {
                    break;
                } else {
                    array[low] = array[high];
                }
                while (low < high && array[low] <= temp) {
                    low++;
                }
                if (low >= high) {
                    break;
                } else {
                    array[high] = array[low];
                }
            }
            array[low] = temp;
            return low;
        }

}
//    private static int[] findKth(int[] array , int start, int end) {
//        if (start < end) {
//            int i = start;
//            int j = end;
//            int x = array[i];
//            while (i < j) {
//                while (i < j && array[j] >= x)
//                    j--;
//                if (i < j)
//                    array[i++] = array[j];
//                while (i < j && array[i] < x)
//                    i++;
//                if (i < j)
//                    array[j--] = array[i];
//            }
//            array[i] = x;
//            findKth(array, start, i - 1);
//            findKth(array, i + 1, end);
//        }
//        return array;
//    }
//    static int Fun(int[] array,int len ,int k){
//        return array[k -1];
//    }
//    public static void main(String[] args) {
//        Scanner scanner1 = new Scanner(System.in);
//        int []array =
//        int K = scanner1.nextInt();
//        //insertSort(array);
//        //findKth(array);
//        array = findKth(array,0,array.length-1);
//        System.out.println(Fun(array,array.length,K));
//    }
//}
//        int tmp = 0;
//        int j = 0;
//        for (int i = 1; i <array.length; i++){
//            tmp = array[i];
//            for (j = i-1 ; j >= 0; j--) {
//                if (array[i] > tmp){
//                    array[j+1] = array[j];
//                }else{
//                    break;
//                }
//            }
//            array[j+1] =tmp;
//        }
//        System.out.println(Arrays.toString(array));
//    }
//public static void insertSort(int[] arr){
//    int j=0;
//    int temp=0; //临时变量
//    for(int i=1 ; i<arr.length ; i++ ){    //从第二数开始比较
//        temp = arr[i];  //将当前数插入到已经有序的数组中
//        for( j=i-1; j>=0; j--){
//            if( arr[j] < temp ){   //如果前面的数大于当前数,将他后移
//                 arr[j+1]=arr[j];
//            }else{
//                break;
//            }
//        }
//        arr[j+1] = temp;    //将当前轮数的数放到应该在的位置
//    }
//    System.out.println(Arrays.toString(arr));
//}
