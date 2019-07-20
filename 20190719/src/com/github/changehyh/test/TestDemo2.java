package com.github.changehyh.test;
import java.util.*;

public class TestDemo2 {
    final static long MOD=1000000007L;
    final static int MAX= 100000;
    public static void main(String[] args) {
        TestDemo2 ts = new TestDemo2();
        ts.sys();
    }
    private void sys() {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLong()){
            long x=scanner.nextLong();
            System.out.println(getRes(x));
        }
    }
    private long getRes(long x) {
        Map<Long,Integer>dist=new HashMap<Long, Integer>();
        Queue<Long>queue=new LinkedList<Long>();
        dist.put(x,0);
        queue.add(x);
        while (!queue.isEmpty()){
            long d;
            Long top=queue.poll();
            if (dist.get(top)>MAX){
                break;
            }
            if (top==0){
                return dist.get(top);
            }
            d=((top<<2)+3)%MOD;
            if (d==0){
                return dist.get(top)+1;
            }
            if (!dist.containsKey(d)){
                queue.add(d);
                dist.put(d,dist.get(top)+1);
            }
            d=((top<<3)+7)%MOD;
            if (d==0){
                return dist.get(top)+1;
            }
            if (!dist.containsKey(d)){
                queue.add(d);
                dist.put(d,dist.get(top)+1);
            }

        }
        return -1L;
    }

}
