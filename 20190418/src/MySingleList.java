public class MySingleList implements ILinked {
    //节点
    class Node {
        public int getData() {
            return data;
        }

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    public MySingleList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //cur所指向的位置是尾节点
            cur.next = node;
        }
    }

    //检查index的合法性
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("Index不合法");
        }
    }

    //找到index-1的位置，函数返回该位置的引用
    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        //头插法
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找关键字key的前驱
    //如果找不到返回null
    private Node searchPre(int key) {
        Node pre = this.head;
        //头节点是要删除的数据节点
        if (pre.data == key) {
            return this.head;
        }
        while (pre.next != null) {
            if (pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        int oldData=0;
     Node pre=searchPre(key);
     if (pre==null){
         throw new UnsupportedOperationException("不存在key节点");
     }
     //是头节点的时候
     if (pre==head&&pre.data==key){
         oldData=this.head.data;
         this.head=this.head.next;
         return oldData;
     }
     //不是头节点
        Node del=pre.next;
        oldData=del.data;
        pre.next=del.next;
        return oldData;
    }
    @Override
    public void removeAllKey(int key) {
        if (this.head==null){
            return;
        }
        Node pre=this.head;
        Node cur=this.head.next;
        while (cur!=null){
            if (cur.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        if (this.head.data==key){
            this.head=this.head.next;
        }
    }
    @Override
    public int getLength() {
        int count=0;
        Node cur=this.head;
        while (cur!=null){//不依赖前驱
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head;
        while (cur!=null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
            System.out.println();
    }
    @Override
    public void clear() {
        while (this.head!=null){
            Node cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }
    //单列表反转
    public Node reverseList() {
        Node cur = this.head;
        Node pre = null;
        Node reverseHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return reverseHead;
    }
    public void show(Node resHead){
        Node cur=resHead;
        while (cur!=null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void reverseList(int data){
        Node cur =this.head;
        this.head.next=null;
        addFirst(data);

    }


    //Oj第三题
    public Node middleNode() {
        int len=getLength()/2;
        Node cur =this.head;
        if (this.head==null){
            return null;
        }if (cur.next==null){
            return null;
        }
        for (int i = 0; i <len; i++) {
            cur=cur.next;
        }
        return cur;
    }

    //OJ第四题
    public Node FindKthToTail(int k) {
        Node fast =this.head;
        Node slow =this.head;
        if (fast==null||k<=0||k>getLength()){
            return null;
        }else {
            while (k-1>0){
                fast=fast.next;
                k--;
            }
            while (fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }
        return slow;
    }

    //OJ第六题
    public Node partition( int x) {
        Node beforeStart=null;
        Node beforeEnd=null;
        Node afterStart=null;
        Node afterEnd=null;
        //pHead遍历单列表
        Node pHead=this.head;
        while (pHead!=null){
            if (pHead.data<x){
                if (beforeStart==null){
                    beforeStart=pHead;
                    beforeEnd=beforeStart;
                }else {
                    beforeEnd.next=pHead;
                    beforeEnd=pHead;
                }
            }else {
                if (afterStart==null){
                    afterStart=pHead;
                    afterEnd=afterStart;
                }else {
                    afterEnd.next=pHead;
                    afterEnd=pHead;
                }

            }
            pHead=pHead.next;
        }
        if (beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }

    //构造一个环
    public void createCycle() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next.next;
    }
    //OJ第十题
    public boolean hasCycle() {
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null||fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    //OJ第十一题
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }return slow;
    }
}
