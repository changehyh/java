package com.hyh.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SystemException extends RuntimeException{
    private String code;

    public SystemException(String message) {
        super("系统异常：" + message);
        code = "501";
    }

    public SystemException(Throwable cause) {
        super("系统异常：" +cause);
        code = "501";
    }
}
