import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDemo2 {
    //一旦程序发生异常，程序将不会向下继续执行
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1、开始计算");
        try {
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            System.out.println("2、进行计算："+x/y);
        }catch (ArithmeticException|InputMismatchException e){
            e.printStackTrace();
            System.out.println("算术发生异常");
        }finally {//永远都会执行  作用：用来关闭资源。
            System.out.println("finally执行");
        }
        System.out.println("3、计算结束");
    }
}
//请使用一个静态内部类实现按一个单利模式
//class  MySingleton{
//    private MySingleton() {
//    }
//    private static class Singleton{
//        public static MySingleton mySingleton=new MySingleton();
//    }
//    public static MySingleton getInstance(){
//        return Singleton.mySingleton;
//    }
//}
//public class TestDemo2 {
//    public static void main(String[] args) {
//        MySingleton mySingleton=MySingleton.getInstance();
//        System.out.println(mySingleton);
//        MySingleton mySingleton2=MySingleton.getInstance();
//        System.out.println(mySingleton2);
//    }
//}
