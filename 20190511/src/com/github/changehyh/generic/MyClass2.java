package com.github.changehyh.generic;
//在泛型类被类型擦除的时候，之前泛型类中的类型参数部分
// 如果没有指定上限，如  <T> 则会被转译成普通的 Object 类型，
// 如果指定了上限如  <T extends Number,E extends CharSequence>
// 则类型参数就被替换成类型上限。
import java.lang.reflect.Field;

public class MyClass2 <T extends Number,E extends CharSequence>{
    private T message;
    private E element;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public static void main(String[] args) {
        MyClass2<Integer,String> myClass2 = new MyClass2<>();
        ///MyClass2 在运行时 message element属性具体类型
        Field[] fields = myClass2.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()+ " " + field.getType());
        }
    }
}
