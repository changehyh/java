package com.hyh.sort;

import java.util.Arrays;

public class MySort {

    public static void main(String[] args) {
        int[] array = {9,7,5,2,8,4,1,3};
        int[] array1 = {9,7,5,2,8,4,1,3};

        quickSort2(array,0,array.length-1);
        heapSort2(array1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }
    //插入排序
    public static void insertSort(int[] array){
        int temp = 0;
        for (int i = 1; i <array.length ; i++) {
            temp = array[i];
            int j = 0;
            for ( j = i-1; j >=0 ; j--) {
                if (array[j] > temp){
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public static void insertSort1(int[] array){
       int tmp = 0;
        for (int i = 1; i <array.length ; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i-1; j>=0; j--) {
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void insertSort2(int[] array){
        int temp = 0;
        for (int i = 1; i <array.length ; i++) {
            temp = array[i];
            int j = 0;
            for ( j = i-1;j >= 0;j--){
                if (array[j] > temp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public static void insertSort3(int[] array){
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = 0;
            for (j = i-1;j>=0;j--){
                if (array[j] > temp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public static void shell2(int [] array,int gap){
        int temp = 0;
        for (int i = gap; i <array.length ; i++) {
            temp = array[i];
            int j = 0;
            for (j = i-gap;j>=0;j-=gap){
               if (array[j] > temp) {
                   array[j + gap] = array[j];
               }else {
                   break;
               }
            }
            array[j+gap] = temp;
        }
    }
    //希尔排序
    public static void shell(int[] array ,int gap){
        int temp = 0;
        for (int i = gap; i <array.length ; i++) {
            temp = array[i];
            int j = 0;
            for (j = i-gap;j >= 0;j -= gap){
                if (array[j] > temp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }
    public static void shellSort(int[] array){
        int [] drr = {5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell1(array,drr[i]);
        }

    }

    public static void shell1(int[] array ,int gap){
        int temp = 0;
        for (int i = gap; i <array.length ; i++) {
            temp = array[i];
            int j = 0;
            for (j = i-gap; j>=0;j-=gap){
                if (array[j] > temp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }

    //直接选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[j]<array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void selectSort2(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void adjust2(int[] array,int start,int end){
        int temp = array[start];
        for (int i = 2*start+1; i <=end; i=i*2+1) {
            if (i < end && array[i] < array[i+1]){
                i++;
            }
            if (array[i] > temp){
                array[start] = array[i];
                start = i;
            }else if (array[i] < temp){
                break;
            }
        }
        array[start] = temp;
    }
    public static void adjust3(int[] array,int start,int end){
        int temp = array[start];
        for (int i = 2*start+1;i <= end ;i=2*i+1){
            if ( i<end && array[i] <array[i+1]){
                i++;
            }
            if (array[i] > temp){
                array[start] = array[i];
                start = i;
            }else if (array[i] < temp){
                break;
            }
        }
        array[start] = temp;
    }

    public static void heapSort2(int[] array){
        //先将树变成大根堆
        for (int i =(array.length-1-1)/2; i >= 0 ; i--) {
            adjust3(array,i,array.length-1);
        }
        //再进行交换
        for (int j = 0; j <array.length-1 ; j++) {
            int temp = array[array.length-1-j];
            array[array.length-1-j] = array[0];
            array[0] =temp;
            adjust3(array,0,array.length-1-j-1);
        }
    }

    //堆排序
    public static void adjust(int[] array,int start ,int end){
        int tmp = array[start];
        for (int i = 2* start+1 ; i <= end; i = i*2+1) {
            if (i <end && array[i] <array[i+1]){
                i++;
            }
            if (array[i] >tmp){
                array[start] = array[i];
                start = i;
            }else if (array[i] <tmp){
                break;
            }
        }
        array[start] = tmp;
    }

    public static void heapSort(int[] array){
        for (int i = (array.length-1-1)/2; i >=0 ; i--) {
            adjust(array,i,array.length-1);
        }
        for (int j = 0; j <array.length-1 ; j++) {
            int temp = array[array.length-1-j];
            array[array.length-1-j] = array[0];
            array[0] = temp;
            adjust(array,0,array.length-1-j-1);
        }
    }


    //堆排序
    public static void adjust1(int[] array ,int start ,int end){
        int temp = array[start];
        for (int i = 2*start+1;i <= end ;i= i*2+1){
            if (i < end && array[i] <array[i+1]){
                i++;
            }
            if (array[i] >temp){
                array[start] = array[i];
                start = i;
            }else if (array[i]<temp){
                break;
            }
        }
        array[start] = temp;
    }
    public static void heapSort1(int[] array){
        //先将将树变成大根堆
        for (int i=(array.length-1-1)/2; i>=0 ; i--) {
            adjust1(array,i,array.length-1);
        }
        //再进行交换
        for (int j = 0; j <array.length-1; j++) {
            int tmp = array[array.length-1-j];
            array[array.length-1-j] = array[0];
            array[0] =tmp;
            adjust1(array,0,array.length-1-j-1);
        }
    }

    //冒泡排序
    public static void paoPao(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    //快速排序
    public static void quickSort(int[] array,int left ,int right){
        if (left >right){
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i != j){
            while (array[j] >= base && j > i){
                j--;
            }
            while (array[i] <= base && i < j){
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left] = array[i];
        array[i] = base;

        quickSort(array,left,i-1);
        quickSort(array,i+1,right);

    }


    //快速排序
    public static void quickSort1(int[] array ,int left,int right){

        int base = array[left];
        int i = left;
        int j = right;

        while (i != j){
            while (array[j] >= base && j >i){
                j--;
            }
            while (array[i] <= base && i < j){
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left] = array[i];
        array[i] = base;

        quickSort1(array,left,i-1);
        quickSort1(array,j+1,right);
    }

    //归并排序
    public static void merge(int[] array,int start,int mid,int end){
        int[] tmpArray = new int[array.length];
        int tmpIndex = start;
        int start2 = mid+1;

        int i = start;
        while (start<=mid && start2<=end){
            if (array[start] <= array[start2]){
                tmpArray[tmpIndex++] = array[start++];
            }else {
                tmpArray[tmpIndex++] = array[start2++];
            }
        }
        while (start<=mid){
            tmpArray[tmpIndex++] = array[start++];
        }
        while (start2<=mid){
            tmpArray[tmpIndex++] = array[start2++];
        }
        while (i<=end){
            array[i] = tmpArray[i];
            i++;
        }
    }
    public static void mergeSort(int[] array,int start,int end){
        if (start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }

    //快速排序
    public static void quickSort2(int[] array ,int left,int right){
        if (left>right){
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i != j){
            while (array[j] >=base && j>i){
                j--;
            }
            while (array[i] <= base && i<j){
                i++;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[left] = array[i];
        array[i] = base;

        quickSort2(array,left,i-1);
        quickSort2(array,j+1,right);
    }
}
