import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestDemo2 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue =  new MyCircularQueue();
        myCircularQueue.enQueue(10);
        myCircularQueue.enQueue(20);
        myCircularQueue.enQueue(30);
        myCircularQueue.enQueue(40);
//        System.out.println(myCircularQueue.deQueue());
        myCircularQueue.Rear();
    }
    public static void main2(String[] args) {
        TestMinStack testMinStack =new TestMinStack();
        testMinStack.push(10);
        testMinStack.push(20);
        testMinStack.push(30);
        testMinStack.push(40);
        testMinStack.pop();
        System.out.println(testMinStack.top());
        System.out.println(testMinStack.getMin());
    }


//    public static void main1(String[] args) {
//        IMyStackImpl iMyStack = new IMyStackImpl();
//        iMyStack.push(10);
//        iMyStack.push(20);
//        iMyStack.push(30);
//        iMyStack.push(40);
//        System.out.println(iMyStack.pop());//40
//        System.out.println(iMyStack.top());//30
//
//    }
//    public static void main(String[] args) {
//        MyQueueImpl myQueue = new MyQueueImpl();
//        myQueue.add(10);
//        myQueue.add(20);
//        myQueue.add(30);
//        myQueue.add(40);
//        System.out.println(myQueue.poll());//10
//        System.out.println(myQueue.peek());//20
//        myQueue.add(50);
//        System.out.println(myQueue.peek());//20
//        System.out.println(myQueue.poll());//20
//
//        System.out.println(myQueue.size());
//        System.out.println(myQueue.poll());//30
//        System.out.println(myQueue.poll());//40
//        System.out.println(myQueue.poll());//50
        //System.out.println(myQueue.poll());

}
