package com.biitech.jcf;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestProperties {
    
    public static void code1() {
        Properties properties = new Properties();
        properties.setProperty("java", "Java is best");
        properties.setProperty("c++", "C++ is best too");
        System.out.println(properties.getProperty("c++"));
        System.out.println(properties.getProperty("php"));
        System.out.println(properties.getProperty("php", "PHP是世界上最好的语言"));
        
    }
    
    public static void code2(){
        //Properties -> fs   *.properties
        File file = new File("E:\\worskpace\\java2_rocket_code\\javase-io-jcf-528\\src\\hello.properties");
        //FileReader BufferedReader Scanner FileInputStream
    
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(file)) {
            //?
            properties.load(reader);
            //1.
//            for (Map.Entry<Object, Object> entry : properties.entrySet()){
//                System.out.println(entry.getKey()+ " = "+entry.getValue());
//            }
            //1,2,3,4
//            properties.list(System.out);
        
            System.out.println(properties.getProperty("java"));
            System.out.println(properties.getProperty("python"));
            System.out.println(properties.getProperty("javascript", "JavaScript和Java是兄弟"));
        
            //set
            properties.setProperty("python", "程序员好帮手");
            try (FileWriter writer = new FileWriter(file)) {
                properties.store(writer, "Add properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
       
        //hello.properties
        //com/biitech/jcf/hello.properties
        Properties properties = new Properties();
        try (InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("com/biitech/jcf/hello.properties")) {
            properties.load(in);
            properties.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
}
