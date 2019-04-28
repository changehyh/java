

// 两个队列实现栈
public class IMyStackImpl {

    private MyQueueImpl myQueue1;
    private MyQueueImpl myQueue2;
    private int usedSize;
    public IMyStackImpl() {
        this.myQueue1 = new MyQueueImpl();
        this.myQueue2 = new MyQueueImpl();
        this.usedSize=0;
    }
    /** 入栈*/
    //入栈入到不为空的栈中，如果都为空，入Q1中
    public void push(int x){
        if (!myQueue1.empty()){
            myQueue1.add(x);
        }else if (!myQueue2.empty()){
            myQueue2.add(x);
        }else {
            myQueue1.add(x);
        }
        this.usedSize++;
    }
//    public void push(int x) {
//        if (!myQueue1.empty()){
//            myQueue1.add(x);
//        }else if (!myQueue2.empty()){
//            myQueue2.add(x);
//        }else {
//            myQueue1.add(x);
//        }
//        this.usedSize++;
//    }
    //出栈
    public int pop() {
        if (empty()){
            return -1;
        }
        int data = 0;
        if (!myQueue1.empty()){
            for (int i = 0; i <this.usedSize-1; i++) {
                myQueue2.add(myQueue1.poll());
            }
            data=myQueue1.poll();
        }else {
            for (int i = 0; i <this.usedSize-1; i++) {
                myQueue1.add(myQueue2.poll());
            }
            data=myQueue2.poll();
        }
        this.usedSize--;
        return data;


//        if (empty()){
//            return -1;
//        }
//        int data = 0;
//        if (!myQueue1.empty()){
//            for (int i = 0; i < this.usedSize-1; i++) {
//                myQueue2.add(myQueue1.poll());
//            }
//            data=myQueue1.poll();
//        } else {
//            for (int i = 0; i < this.usedSize-1; i++) {
//                myQueue1.add(myQueue2.poll());
//            }
//            data=myQueue2.poll();
//        }
//        this.usedSize--;
//        return data;
    }

    /** Get the top element. */
    public int top() {
        if (empty()){
            return -1;
        }
        int data = 0;
        if (!myQueue1.empty()){
            for (int i = 0; i < this.usedSize; i++) {
                data = myQueue1.poll();
                myQueue2.add(data);
            }
        }else {
            for (int i = 0; i < this.usedSize; i++) {
                data=myQueue2.poll();
                myQueue1.add(data);
            }
        }
        return data;
    }

    public boolean empty() {
        return this.usedSize==0;
    }

    public int size(){
        return this.usedSize;
    }

}
