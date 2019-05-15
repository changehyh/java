package com.changehyh.github.testdemo;

class Person{
    private String name;
    private Integer age;
    public Person(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@FunctionalInterface
public interface IUtil3<R,PN,PA> {
    public R createPerson(PN p1,PA p2);

    public static void main(String[] args) {
        IUtil3<Person,String,Integer> iUtil3 = Person::new;
        System.out.println(iUtil3.createPerson("huyuhang",23));
    }
}
