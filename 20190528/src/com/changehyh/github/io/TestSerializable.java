package com.changehyh.github.io;

import java.io.*;
import java.util.Date;

//序列化 和  反序列化
public class TestSerializable {
    public static void main1(String[] args) {
        Person person = new Person();
        person.setAge(28);
        person.setName("Jack");
        person.setSkills(new String[]{"java","PHP","C++"});
        person.setBirthday(new Date());

        try(ObjectOutputStream oout = new ObjectOutputStream(
                new FileOutputStream("D:"+ File.separator+"_test"+File.separator+"Person.data")
        )){oout.writeObject(person);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("D:"+File.separator+"_test"+File.separator+"Person.data");

        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))){
            Object object = oin.readObject();
            Person person = (Person) object;
            System.out.println(person);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
