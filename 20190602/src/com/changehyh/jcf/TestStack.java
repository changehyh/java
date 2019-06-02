package com.biitech.jcf;

import java.util.Stack;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestStack {
    
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("C++");
        stack.push("Python");
        stack.push("Golang");
    
        System.out.println("栈的大小："+stack.size());
        System.out.println("栈是否为空："+stack.isEmpty());
        System.out.println("观察栈顶："+stack.peek());//Golang
        System.out.println("出栈："+stack.pop());
        System.out.println("出栈："+stack.pop());
        System.out.println("出栈："+stack.pop());
        System.out.println("出栈："+stack.pop());
        
        //EmptyStackException
        System.out.println("出栈："+stack.pop());
    }
    
}
