package com.bittech.io;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Author: secondriver
 * Created: 2019/5/28
 */
public class Person implements Serializable {
 
    private String name;
    private transient Integer age;
    private String[] skills;
    private Date birthday;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String[] getSkills() {
        return skills;
    }
    
    public void setSkills(String[] skills) {
        this.skills = skills;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + Arrays.toString(skills) +
                ", birthday=" + birthday +
                '}';
    }
}
