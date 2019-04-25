import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestDemo1 {
    //编写一个程序，找到两个单链表相交的起始节点。

    public static void createCut(MySingleList.Node headA,MySingleList.Node headB) {
        headA.next.next = headB.next.next;
    }

    public static MySingleList.Node getIntersectionNode
            (MySingleList.Node headA,MySingleList.Node headB){
        MySingleList.Node pLong = headA;
        MySingleList.Node pShort = headB;
        int lenA = 0;
        while (pLong!=null){
            lenA++;
            pLong=pLong.getNext();
        }
        int lenB = 0;
        while (pShort!=null){
            lenB++;
            pShort=pShort.getNext();
        }
        pLong=headA;
        pShort=headB;

        int myLen = lenA - lenB;

        if (myLen<0){
            pLong=headB;
            pShort=headA;
            myLen= lenB-lenA;
        }
        for (int i = 0; i < myLen; i++) {
            pLong = pLong.getNext();
        }
        //起点相同了
        while (pLong != null && pShort != null && pLong != pShort){
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }
        if (pLong == pShort && pLong != null && pShort != null){
            return pLong;
        }
        return null;
    }

//    public static void main(String[] args) {
//        MySingleList mySingleList = new MySingleList();
//        mySingleList.addFirst(88);
//        mySingleList.addFirst(98);
//        mySingleList.addFirst(76);
//        mySingleList.addFirst(40);
//        mySingleList.addFirst(30);
//        mySingleList.addFirst(10);
//        mySingleList.display();
//        MySingleList mySingleList1 =new MySingleList();
//        mySingleList1.addFirst(10);
//        mySingleList1.addFirst(14);
//        mySingleList1.addFirst(19);
//        mySingleList1.addFirst(25);
//        mySingleList1.addFirst(35);
//        mySingleList1.display();
//        System.out.println("====================================");
//        createCut(mySingleList.getHead(),mySingleList1.getHead());
//        mySingleList.display();
//        mySingleList1.display();
//        MySingleList.Node cur = getIntersectionNode(
//                mySingleList.getHead(),mySingleList1.getHead());
//        System.out.println(cur.getData());
//    }










    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(10);
        mySingleList.addFirst(20);
        mySingleList.addFirst(30);
        mySingleList.addFirst(40);
        mySingleList.addFirst(50);
        mySingleList.addFirst(60);
        mySingleList.display();
        MySingleList.Node res = mySingleList.reverseList();
        mySingleList.show(res);
    }
//        MySingleList.Node cur = mySingleList.middleNode();
//        System.out.println(cur.getData());
//
//        MySingleList.Node cur1 = mySingleList.findKthToTail(2);
//        System.out.println(cur1.getData());
//
//        MySingleList.Node res1 =mySingleList.partition(30);
//        mySingleList.show(res1);

//        mySingleList.createCycle();
//        System.out.println(mySingleList.hasCycle());
//
//        MySingleList.Node cur1 = mySingleList.detectCycle();
//        System.out.println(cur1.getData());

//        System.out.println("===========================");
//        mySingleList.addLast(10);
//        mySingleList.addLast(20);
//        mySingleList.addLast(30);
//        mySingleList.addLast(40);
//        mySingleList.addLast(50);
//        mySingleList.addLast(60);
//        mySingleList.display();
//        System.out.println("===========================");
//        mySingleList.addIndex(1,88);
//        mySingleList.display();
//        System.out.println("===========================");
//        System.out.println(mySingleList.contains(10));
//        System.out.println("===========================");
//        mySingleList.remove(30);
//        mySingleList.display();
//        System.out.println("===========================");
//        mySingleList.removeAllKey(30);
//        mySingleList.display();
//        System.out.println("===========================");
//        mySingleList.clear();

}
