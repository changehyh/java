package com.biitech.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestStream {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "PHP", "SQL", "Python", "C", "C#", "Golang", "E", "R", "JavaScript", "VB", "Rust", "Perl", "Ruby", "F#", "Cobol", "Groovy", "kotlin", "Scala", "ActionScript", "HTML", "CSS");

//        list.forEach(s-> System.out.println(s));
//        list.forEach(System.out::println);

//        System.out.println(list.size());
//        System.out.println(list.stream().count());

//        List<String> newList = new ArrayList<>();
//        for (String item : list) {
//            if (item.contains("Java")) {
//                newList.add(item);
//            }
//        }
//        System.out.println(newList);

//        System.out.println(list.stream().filter(s->s.contains("Java")|| s.contains("C")).count());

//        System.out.println(list
//                .stream()
//                .map(String::toLowerCase)
//                .filter(s -> s.contains("c"))
//                .filter(s -> s.length() > 2)
//                .collect(Collectors.toList()));
        
        
        System.out.println(list.stream().skip(2).limit(5).filter(s -> s.contains("C")).collect(Collectors.toList()));
    }
}
