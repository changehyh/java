public class TestDemo1 {
    public static void leftRotateString(String str,int n){
        char[] arr = str.toCharArray();
        char[] arr1 = new char[arr.length];
        int count =0;
        for(int i= n ;i<arr.length;i++ ){
            arr1[count]=arr[i];
            count++;
        }
        for(int j = 0;j<n;j++){
            arr1[count]= arr[j];
            count++;
        }
        String str1= new String (arr1);
        System.out.println(str1);
    }

    public static void main(String[] args) {
        leftRotateString("abcdef",2);
    }
}

//    public static void leftRotateString(String str,int n){
//        char[] arr=str.toCharArray();
//        char[] arr2=new char[arr.length];
//        int a =0;
//        for (int i=n;i<arr.length;i++){
//            arr[a]=arr[i];
//            a++;
//        }
//        for (int i=0;i<n;i++){
//            arr[a]=arr[i];
//            a++;
//        }
//        String str1=new String(arr2);
//        System.out.println(str1);
//    }
//    public static void main(String[] args) {
//        leftRotateString("abcdef",2);
//    }
//}
