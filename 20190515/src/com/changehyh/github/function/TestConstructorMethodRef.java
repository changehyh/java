package com.changehyh.github.function;

public class TestConstructorMethodRef {
    public static void main(String[] args) {

        Person person1 = new Person();
        System.out.println(person1);
        Person person2 = new Person(22,"hyh");
        System.out.println(person2);
        // y = f(m, n)
        // y = Person类型
        // m = Integer类型
        // n = String类型
        // f = 根据m n 创建一个Person

        //new Person()
        //new Person(Integer,String)
        ObjectFactory<Integer,String,Person> factory = (p1,p2)->{
          return new Person(p1,p2);
        };
        Person person3 = factory.createObject(20,"Alice");
        System.out.println(person3);

        //构造方法引用
        ObjectFactory<Integer,String,Person> factory1 = Person::new;
        Person person4 = factory1.createObject(20,"TOM");
        System.out.println(person4);

        //方法引用 ：打通函数实现和面向对象的方法

    }
}
class Person{
    private Integer age;
    private String name;
    public Person(){

    }
    public Person(Integer age,String name){
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {

        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
@FunctionalInterface
interface ObjectFactory<P1,P2,R>{
    R createObject(P1 p1,P2 p2);
}