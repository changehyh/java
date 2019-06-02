package com.biitech.jcf;

import java.util.Hashtable;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestHashtable {
    
    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","Java");
        hashtable.put("2",null);
        System.out.println(hashtable);
    }
}
