import java.util.Arrays;
import java.util.Random;
public class TestMySort {
    //直接插入排序越有序越快
    public static void insertSort(int[]array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;//array[j+1] = array[j];
                    // 说明前面的数据已经有序，直接break；
                }
            }
            array[j + 1] = temp;
        }
    }
    //组数
    //进行直接插入排序
    public static void shell(int[] array,int gap) {
        int temp = 0;
        for (int i = gap; i <array.length; i++) {
            temp = array[i];
            int j = 0;
            for (j = i-gap; j >=0; j-=gap) {
                if (array[j]>temp){
                    array[j+gap]=array[j];
                }else {
                    break;
                }
            }
            array[j+gap]=temp;
        }
    }
    //希尔排序
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for (int i = 0; i <drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    //直接选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

//    public static void adjust(int[] array,int start,int end) {
//        int temp = array[start];
//        for (int i = 2*start+1; i <=end; i=i*2+1) {
//            if (i<end && array[i]>array[i+1]){
//                i++;
//            }
//            if (array[i]>temp){
//                array[start] = array[i];
//                start=i;
//            }else if (array[i]<temp){
//                break;
//            }
//        }
//        array[start] =temp;
//    }
//    public static void heapSort(int[] array){
//        for (int i = 0; i <((array.length-1)/2); i--) {
//            adjust(array,0,array.length-1);
//        }
//        for (int j = 0; j <array.length-1; j++) {
//            int temp = array[array.length-1-j];
//            array[array.length-1-j]=array[0];
//            array[0]=temp;
//            adjust(array,0,array.length-1-j-1);
//        }
//    }

    /**二叉树*/
    //一棵树
        public static void adjust(int[] array,int start,int end) {
        int temp = array[start];
        for (int i = 2*start + 1; i <= end; i = i*2 + 1) {
            //找到左右孩子的最大值的下标 i
            if ((i < end) && array[i] < array[i + 1]) {
                i++;//左右孩子里面的最大值下标
            }
            if (array[i] > temp) {
                array[start] = array[i];
                start = i;
            } else if (array[i] < temp) {
                break;
            }
        }
        array[start] = temp;
    }
    //整棵树
    public static void heapSort(int[] array) {
        //确定start的值
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
                adjust(array,i,array.length-1);
        }
        //调整整棵树
        for (int j = 0; j < array.length-1; j++) {
            int temp =array[array.length-1-j];
            array[array.length-1-j] = array[0];
            array[0] = temp;
            //array.length-1-j  -1:上面已经交换说明有序了
            //调整的时候，不需要调整有序的数据。
            adjust(array,0,array.length-1-j-1);
        }
    }

    public static int partion(int[] array,int low,int high){
        int temp = array[low];
        while (low<high){
            while ((low < high) && array[high] >= temp){
                high--;
            }
            //比较下标
            if (low>=high){
                break;
            }else {
                array[low]=array[high];
            }
            while ((low < high) && array[low] <= temp){
                low ++;
            }
            //比较下标
            if (low>=high){
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low]=temp;
        return low;
    }
    //优化快速排序
    public static void insertSort1(int[] array,int start,int end){
        int temp = 0;
        for (int i = start+1; i <=end; i++) {
             temp = array[i];
             int j = 0;
             for (j = i-1;j >=start;j--) {
                if(array[j]>temp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
             }
            array[j+1] = temp;
        }
    }

    public static void swap(int[] array,int start,int end){
        int temp = array[start];
        array[start]= array[end];
        array[end] =temp;
    }
    public static void medianOfThree(int[] array,int low,int high){
        int mid =(low+high)>>>1;
        if (array[mid]>array[low]) {
            swap(array, low, mid);
        }
        if (array[mid]>array[high]) {
            swap(array, mid, high);
        }
        if (array[low]>array[high]){
            swap(array,low,high);
        }
    }

    public static void quick(int[] array,int start,int end) {

        if (end-start+1 <= 16){
            insertSort1(array,start,end);
            return;
        }

        medianOfThree(array,start,end); //减少递归的次数

        int par = partion(array,start,end);
        // par为基准
        //左边是否有两个数据以上
        if (par>start+1){
            quick(array,start,par-1);
        }
        //右边是否有两个数据以上
        if (par<end-1){
            quick(array,par+1,end);
        }
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }


    //快速排序非递归
    public static void quickSort1(int[] array){
        int[] stack = new int[array.length*2];
        int top = 0;

        int low = 0;
        int high = array.length-1;
        //先进性一趟快速排序
        int par = partion(array,low,high);
        //1、判断当前par 的左右两边是否有两个数据以上
        if(par > low+1){
            stack[top++] = low;
            stack[top++] = par-1;
        }
        if(par < high-1){
            stack[top++] = par+1;
            stack[top++] = high;
        }
        //以上代码执行完毕，两边的谁对已经全部入栈
        while (top > 0){
            high = stack[--top];
            low = stack[--top];
            par=partion(array,low,high);
            if(par > low+1){
                stack[top++] = low;
                stack[top++] = par-1;
            }
            if(par < high-1){
                stack[top++] = par+1;
                stack[top++] = high;
            }
        }
    }


    /**归并排序的特性总结*/
    //1. 归并的缺点在于需要O(N)的空间复杂度，归并排序的思考更多的是解决在磁盘中的外排序问题。
    //2. 时间复杂度：O(N*logN)
    //3. 空间复杂度：O(N)
    //4. 稳定性：稳定

    /**合并过程*/
    public static void merge(int[] array,int start,int mid,int end){
        int[] tempArray = new int[array.length];
        int tempIndex = start;

        int start2 = mid+1;

        int i =start;
        while (start<= mid&& start2<=end){
            if (array[start]<=array[start2]){
                tempArray[tempIndex++] = array[start++];
            }
            else{
                tempArray[tempIndex++] = array[start2++];
            }
        }
        //退出循环后可能有
        while (start<=mid){
            tempArray[tempIndex++] = array[start++];
        }

        while (start2<=end){
            tempArray[tempIndex++] = array[start2++];
        }
        //拷贝过程
        while (i<=end){
            array[i] = tempArray[i];
            i++;
        }
    }

    public static void mergeSort(int[] array ,int start,int end){
        if (start>=end) {
            return;
        }
        int mid = (start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);//分解
        //肯定hi是一个一个有序的序列
        //合并过程
        merge(array,start,mid,end);
    }
    public static void main(String[] args) {
       int[] array = {12,4,2,36,21,7,9,5,34,37,22};
//        Random random = new Random();
//        int[] array = new int[100000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(10000)+1;
//        }
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
