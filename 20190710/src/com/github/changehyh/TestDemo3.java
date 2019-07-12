package com.github.changehyh;
import java.util.*;

public class TestDemo3 {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int stard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        
    }
}
