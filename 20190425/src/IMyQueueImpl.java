//栈实现队列
public class IMyQueueImpl {

    private MyStackImpl myStack1;
    private MyStackImpl myStack2;
    private int usedSize;
    public IMyQueueImpl(){
        this.myStack1 = new MyStackImpl(10);
        this.myStack2 = new MyStackImpl(10);
        this.usedSize= 0;
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
            myStack1.push(x);
        this.usedSize++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!myStack2.empty()) {
            myStack2.pop();
        }
        while (!myStack1.empty()) {
                myStack2.push(myStack1.pop());
            }
            int data = myStack2.pop();
            while (!myStack2.empty()) {
                myStack1.push(myStack2.pop());
            }
            return data;
    }


    /** Get the front element. */
    public int peek() {
        if (empty()){
            return -1;
        }
        if (!myStack2.empty()) {
            myStack2.peek();
        }
        while (!myStack1.empty()) {
            myStack2.push(myStack1.pop());
        }
        int data = myStack2.pop();
        myStack2.push(data);
        while (!myStack2.empty()) {
            myStack1.push(myStack2.pop());
        }
        return data;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.usedSize==0;
    }
}
