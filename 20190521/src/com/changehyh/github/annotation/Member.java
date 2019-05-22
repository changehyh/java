package com.changehyh.github.annotation;

import java.io.Serializable;

@SuppressWarnings(value = {"unused"})
@Deprecated
@MyAnnotation
public class Member implements Serializable {

    @Override
    @Deprecated
    public String toString() {
        return super.toString();
    }
}
