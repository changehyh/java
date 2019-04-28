//设计循环队列。
public class MyCircularQueue {
    private int front;
    private int rear;
    private int [] elem;
    private int usedSize;
    public  MyCircularQueue(){
        this.front = 0;
        this.rear = 0;
        this.elem = new int[10];
    }

    /** 入队*/
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear]=value;
        this.rear = (this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }

    /** 出队 */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        this.usedSize--;
        return true;
    }

    /** 得到队首元素 */
    public int Front() {
        if (isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.elem[this.front];
    }

    /** 得到队尾元素 */
    public int Rear() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        int tmp = (this.rear == 0 ? this.elem.length-1 : this.rear-1);
        return this.elem[tmp];
    }

    /** 队列是否为空 */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /** 队列是否为满 */
    public boolean isFull() {
        if ((this.rear+1) % this.elem.length==this.front){
            return true;
        }
        return false;
    }
}
