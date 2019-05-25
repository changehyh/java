package com.changehyh.github.annotation;

public class Factory {
    private Factory(){

    }

    public static Fruit getFruit(){
        MyAnnotation myAnnotation = ObjectDesc.class.getAnnotation(MyAnnotation.class);
        Class cls = myAnnotation.target();
        try {
            return (Fruit) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
