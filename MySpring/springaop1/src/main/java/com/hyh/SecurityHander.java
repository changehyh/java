package com.hyh;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecurityHander {
    /**
     * PointCut 标识一个范围
     */
   @Pointcut("execution(* com.hyh.*.*(..))")
    private void allMethod(){}

    /**
     * Advice [Before]
     */
    //横切关注点
    @Before("allMethod()")
    public void checkSecurity(){
        System.out.println("==========checkSecurity()===========");
    }
}
