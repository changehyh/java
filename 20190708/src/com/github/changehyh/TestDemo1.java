package com.github.changehyh;

public class TestDemo1 {
    public static void main(String[] args) {
        int [] array = {1,2,4,3,7,6,12,8,9};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(array);
        testHeap.show();
        testHeap.pushHeap(11);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        testHeap.HeapSort();
        testHeap.show();
        testHeap.HeapSort2();
        testHeap.show();
    }
}
