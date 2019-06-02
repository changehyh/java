package com.biitech.jcf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestQueue {
    
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("C++");
        queue.add("C#");
        queue.add("PHP");
    
        System.out.println("队列是否为空："+queue.isEmpty());
        System.out.println("队列元素个数："+queue.size());
        System.out.println("出队列："+queue.poll());//Java
        System.out.println("观察队头："+queue.peek());//C++
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
        System.out.println("出队列："+queue.poll());
    }
}
