import javax.xml.soap.Node;

public class MySingleList implements ILinked{
    class Node {
        public int getData() {
            return data;
        }

        private int data;

        public Node getNext() {
            return next;
        }

        public Node next;
        public Node(int data){
            this.data=data;
        }
    }

    public Node getHead() {
        return head;
    }

    private  Node head;
    public MySingleList(){
        this.head=null;
    }

    //尾插法
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    @Override
    public void addLast(int data) {
        Node node =new Node(data);
        if (this.head==null){
            this.head=node;
        }else {
            Node cur = this.head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    //检查Index的合法性
    private void checkInedx(int index){
        if (index < 0 || index>getLength()){
            throw new UnsupportedOperationException("Index不合法");
        }
    }
    //找到index-1 的位置  函数返回该位置的节点引用
    private Node searchIndex(int index){
        int count=0;
        Node cur = this.head;
        while (count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    @Override
    public boolean addIndex(int index, int data) {
        checkInedx(index);
        if (index==0){
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        return true;
    }

    //查找是否包含关键字key是否在单链表当中
    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //查找关键字key 的前驱
    //如果找不到返回null
    private Node searchPre(int key){
        Node per = this.head;
        if (per.data == key ){
            return this.head;
        }
        while (per.next!=null){
            if (per.next.data==key){
                return per;
            }
            per = per.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);//查找关键字key 的前驱
        if (pre == null) {
            throw new UnsupportedOperationException("不存在key");
        }
        //是头节点的时候
        if (pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node del = pre.next;
        oldData = del .data;
        pre.next = del.next;
        return oldData;
    }

    //删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        if(this.head == null){
            return;
        }
        Node pre =this.head;
        Node cur =this.head.next;
        if (this.head.data==key){
            this.head=this.head.next;
        }
        while (cur!=null){
            if (cur.data==key){
                pre.next=cur.next;
                cur = cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur =this.head;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();;
    }

    @Override
    public void clear() {
        while (this.head!=null){
            Node cur = this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }

    //单链表反转
//    public Node reverseList() {
//        Node cur = this.head;
//        Node prev = null;
//        Node reverseHead=null;
//        while (cur != null){
//            Node curNext = cur.next;
//            if(curNext==null){
//                reverseHead=cur;
//            }
//            cur.next=prev;
//            prev = cur;
//            cur=curNext;
//        }
//        return reverseHead;
//    }

    public void show(Node resHead) {
        Node cur = resHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //找到中间节点--》快慢指针方法
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        if (fast==null||fast.next==null){
            return head;
        }
        while (fast != null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //寻找倒数第 k 个节点
    public Node findKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (fast==null||fast.next==null){
            return null;
        }
        //fast走k-1布
        while (k-1>0){
            if (fast.next!=null) {
                fast = fast.next;
                k--;
            }else {
                return null;
            }
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //链表分割
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead =this.head;
        while (pHead!=null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if (pHead.data < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            } else {
                if (afterStart == null) {
                afterStart = pHead;
                afterEnd = afterStart;
                } else {
                afterEnd.next = pHead;
                afterEnd = pHead;
                }
            }
            pHead=pHeadNext;
        }
        if (beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }

    //构造一个环
    public void createCycle(){
        Node cur=this.head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next.next.next;
    }

    //判断是否有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
//    public Node detectCycle() {
//        Node fast = this.head;
//        Node slow = this.head;
//        while (fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if (slow==fast){
//                break;
//            }
//        }
//        if (fast==null||fast.next==null){
//            return null;
//        }
//        slow=this.head;
//        while (slow!=fast){
//            slow=slow.next;
//            fast=fast.next;
//        }
//        return slow;
//    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针
//    public Node deleteDuplication() {
//        Node newHead = new Node(-1);
//        Node tmpHead = newHead;
//        Node cur = this.head;
//        while (cur!=null){
//            if (cur.next!=null&&cur.data==cur.next.data){
//                //cur 所指向的节点是一个重复节点
//                while (cur.next!=null&&cur.data==cur.next.data){
//                    cur=cur.next;
//                }
//                cur=cur.next;
//                newHead.next=cur;
//                //在这个地方应该串起来
//            }else {
//                newHead.next=cur;
//                newHead = cur;
//                cur = cur.next;
//            }
//        }
//        return tmpHead.next;
//    }
    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tempHead=newHead;
        Node cur =this.head;
        while (cur!=null){
            if (cur.next!=null&&cur.data==cur.next.data){
                while (cur.next!=null&&cur.next.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
                newHead.next=cur;
            }else {
                newHead.next=cur;
                newHead=cur;
                cur=cur.next;
            }
        }
        return tempHead;
    }

    //回文结构
//    public boolean chkPalindrome() {
////        if (this.head == null){
////            return false;
////        }else if (this.head.next==null){
////            return true;
////        }
////        Node fast = this.head;
////        Node slow = this.head;
////        while (fast!=null&&fast.next!=null){
////            fast = fast.next.next;
////            slow = slow.next;
////        }
////        Node p =slow.next;
////        Node pNext = p.next;
////        while (p!=null){
////            p.next = slow;
////            slow = p;
////            p = pNext;
////            if (p!=null){
////                pNext=p.next;
////            }
////        }
////        while (head!=slow){
////            if (head.data!=slow.data){
////                return false;
////            }
////            if (head.next==slow){
////                return true;
////            }
////            head = head.next;
////            slow = slow.next;
////        }
////        return true;
////    }
    public boolean chkPalindrome() {
        if (this.head==null){
            return false;
        }else if (this.head.next==null){
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node P =slow.next;
        if (P!=null) {
            Node pNext = P.next;
            while (P != null) {
                P.next = slow;
                slow = P;
                P = pNext;
                if (P != null) {
                    pNext = P.next;
                }
            }
        }
        while (this.head != slow){
            if (head.data!=slow.data){
                return false;
            }
            if (head.next==slow){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }

    public Node detectCyle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        if (fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public Node reverseList(){
        Node cur=this.head;
        Node pre=null;
        Node reverseHead=null;
        while (cur!=null){
            Node curNext = cur.next;
            if (curNext==null){
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return reverseHead;
    }

}
