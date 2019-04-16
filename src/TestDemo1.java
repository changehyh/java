import java.util.Arrays;

public class TestDemo1{
    public static void main(String[] args) {
        MySequencelmpl mySequencelmpl=new MySequencelmpl();
        mySequencelmpl.add(0,18);
        mySequencelmpl.add(1,"hyh");
        mySequencelmpl.add(2,"change");
        mySequencelmpl.add(1,99);
        mySequencelmpl.display();
        System.out.println(mySequencelmpl.remove("hyh"));
        mySequencelmpl.display();
        System.out.println(mySequencelmpl.contains("change"));
        mySequencelmpl.clear();
        mySequencelmpl.display();

    }


//    public static void bubbleSort(int[] array) {
//        for (int i = 0; i < array.length-1; i++) {
//
//            boolean swap = false;
//
//            for (int j = 0; j < array.length-1-i; j++) {
//                if(array[j] > array[j+1]) {
//
//                    int tmp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = tmp;
//                    swap = true;
//                }
//            }
//            if(!swap) {
//                break;
//            }
//        }
//    }
//    public static void main1(String[] args) {
//        int[] array = {12,4,2,7,8,3,5};
//        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));
//    }
}




