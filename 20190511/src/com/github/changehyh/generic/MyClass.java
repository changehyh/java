package com.github.changehyh.generic;

//类型擦出

//泛型信息只存在于代码编译阶段，在进⼊ JVM 之
// 与泛型相关的信息会被擦除掉，专业术语叫做类型擦除。
//通俗地讲，泛型类和普通类在 java 虚拟机内是没有什么特别的地方。
public class MyClass <T>{
    private T message;

    public T getMessage(){
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public static void main(String[] args) {
        //1. 泛型类在使用时（运行）和普通类没有区别
        //2. 验证 运行时 T 正真类型
        MyClass myClass1 = new MyClass();
        MyClass <String>myClass2 = new MyClass<>();
        MyClass <Integer>myClass3 = new MyClass<>();

        //反射
        System.out.println(myClass1.getClass());
        System.out.println(myClass2.getClass());
        System.out.println(myClass3.getClass());

    }
}
