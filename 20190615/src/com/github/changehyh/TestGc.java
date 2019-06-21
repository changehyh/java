package com.github.changehyh;

public class TestGc {
    private TestGc instance;
    private byte[] data = new byte[4*1024*1024];

    public static void main(String[] args) {
        TestGc testGc1 = new TestGc();
        TestGc testGc2 = new TestGc();
        testGc1.instance = testGc2;
        testGc2.instance = testGc1;
        testGc1 = null;
        testGc2 = null;
        System.gc();
    }
}
