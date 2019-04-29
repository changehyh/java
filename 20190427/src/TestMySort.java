import java.util.Arrays;
import java.util.Random;

public class TestMySort {

    /**直接插入排序的特性总结：*/
    //1. 元素集合越接近有序，直接插入排序算法的时间效率越高
    //2. 时间复杂度：O(N^2)
    //3. 空间复杂度：O(1)，它是一种稳定的排序算法
    //4. 稳定性：稳定
    //直接插入排序越有序越快
    public static void insertSort(int[] array){
        int tmp = 0;
        for (int i = 1; i <array.length; i++) {
            tmp=array[i];
            int j =0;
            for (j = i-1; j >=0; j--) {
                if (array[j]>tmp) {
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }

    /**希尔排序的特性总结：*/
    //1. 希尔排序是对直接插入排序的优化。
    //2. 当gap > 1时都是预排序，目的是让数组更接近于有序。当gap == 1时，数组已经接近有序的了，这样就
    //会很快。这样整体而言，可以达到优化的效果。我们实现后可以进行性能测试的对比。
    //3. 希尔排序的时间复杂度不好计算，需要进行推导，推导出来平均时间复杂度： O(N^1.3—N^2）
    //4. 稳定性：不稳定
    public static void shell(int[] array,int gap){
        int tmp = 0;
        for (int i = gap; i <array.length; i++) {
            tmp=array[i];
            int j =0;
            for (j = i-gap; j >=0; j -= gap) {
                if (array[j]>tmp) {
                    array[j + gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array){
        long start = System.currentTimeMillis();
        int[] drr = {5,3,1};
        for (int i = 0; i <drr.length; i++) {
            shell(array,drr[i]);
        }
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**直接选择排序的特性总结：*/
    //1. 直接选择排序思考非常好理解，但是效率不是很好。实际中很少使用
    //2. 时间复杂度：O(N^2)
    //3. 空间复杂度：O(1)
    //4. 稳定性：不稳定    判断数据是否有跳跃式的交换
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length;i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**直接选择排序的特性总结：*/
    //1. 堆排序使用堆来选数，效率就高了很多。
    //2. 时间复杂度：O(N*logN)
    //3. 空间复杂度：O(1)
    //4. 稳定性：不稳定

    //一次调整为大根堆的时间复杂度为多少？
    //log2n
    //整棵树调整为大根堆的时间复杂度为多少？
    //n*log2n
    public static void adjust(int[] array,int start,int end){
        int tmp = array[start];
        for (int i = 2*start+1; i <=end; i= i*2+1) {
            if (i<end && array[i]<array[i+1]) {
                i++;//找到左右孩子的最大值的下标
            }
            if (array[i] > tmp){
                    array[start] = array[i];
                    start = i;
            } else
                if (array[i] < tmp) {
//                    array[start] = tmp;
                    break;
            }
        }
        array[start] = tmp;
    }


    public static void heapSort(int[] array){
        long start = System.currentTimeMillis();
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjust(array,i,array.length-1);
        }
        for (int j = 0; j < array.length-1; j++) {
            int tmp = array[array.length-1-j];
            array[array.length-1-j]=array[0];
            array[0] = tmp;
            //array.length-1-j   -1:上面已经交换说明有序了
            //调整的时候，不需要调整有序的数据
            adjust(array,0,array.length-1-j -1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


//
//    public static int partion(int[] array,int low,int high) {
//        int tmp = array[low];
//        while (low < high) {
//            while ((low < high) && array[high] >= tmp) {
//                high--;
//            }
//            if (low >= high) {
//                break;
//            } else {
//                array[low] = array[high];
//            }
//            while ((low < high) && array[low] <= tmp) {
//                low++;
//            }
//            if (low >= high) {
//                break;
//            }else {
//                array[high] = array[low];
//            }
//        }
//        array[low]=tmp;
//        return low;
//    }



    /**快速排序的特性总结：*/
    //1. 快速排序整体的综合性能和使用场景都是比较好的，所以才敢叫快速排序
    //2. 时间复杂度：O(N*logN)
    //3. 空间复杂度：O(logN)
    //4. 稳定性：不稳定

    public static int partion(int[] array,int low,int high) {
        int temp = array[low];
        while (low<high){
            while (low<high && array[high]>=temp){
                high--;
            }if (low>=high){
                break;
            }else {
                array[low] = array[high];
            }
            while (low<high && array[low]<=temp){
                low++;
            }if (low>=high){
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low] = temp;
        return low;
    }
    //优化快速排序
    public static void insertSort1(int[] array,int start,int end){
        int tmp = 0;
        for (int i = start+1; i <= end; i++) {
            tmp=array[i];
            int j =0;
            for (j = i-1; j >=start; j--) {
                if (array[j]>tmp) {
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1]=tmp;
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
    public static void quick(int[] array,int start,int end){

        if (end-start+1 <= 16){
            insertSort1(array,start,end);
            return;
        }
        medianOfThree(array,start,end);
        //调换三个数位置
        int par = partion(array,start,end);
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
        long start = System.currentTimeMillis();
        quick(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
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
//        int[] array ={12,8,3,5,9,15,10,2,23,45};
        Random random =new Random();
        int [] array=new int[1000];
        for (int i = 0; i < array.length ; i++) {
            array[i]=random.nextInt(1000)+1;
        }
        quickSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
