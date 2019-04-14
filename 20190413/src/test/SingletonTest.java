package test;
class  Singleton{
    //在内部类可以访问私有结构，所以可以在类的内部产生实例化对象
//    private final static  Singleton instance=new Singleton();
    private  static  Singleton instance;
    private Singleton(){   //声明构造
    }
    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
    public  void print(){
        System.out.println("hello world");
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton=null;//声明对象
        singleton =Singleton.getInstance();
        singleton.print();
    }
}
