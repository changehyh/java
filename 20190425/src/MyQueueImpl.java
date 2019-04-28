

//队列
public class MyQueueImpl implements IMyQueue {
    class Node {
        private  int data;
        public Node(int data){
            this.data=data;
        }
        private Node next;
    }
    private  Node front;
    private  Node rear;
    private  int usedSize;
    public MyQueueImpl(){
        this.front=null;
        this.rear=null;
        this.usedSize=0;
    }
    // 判断这个队列是否为空
    @Override
    public boolean empty() {
        return this.usedSize==0;
    }

    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if (empty()){
            return -1;
        }
        return this.front.data;
    }

    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData = this.front.data;
        if (this.usedSize==1){
            this.front=null;
            this.rear = null;
        }else {
            this.front=this.front.next;
        }
        this.usedSize--;
        return oldData;
    }

    // 将 item 放入队列中
    @Override
    public void add(int item) {
        Node node=new Node(item);
        if (empty()){
            this.front=node;
            this.rear=node;
        }else {
            this.rear.next=node;
            this.rear=node;
        }
        this.usedSize++;
    }

    // 返回元素个数
    @Override
    public int size() {
        return this.usedSize;
    }
}
