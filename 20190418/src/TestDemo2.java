
public class TestDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MySingleList mySingleList=new MySingleList();
        mySingleList.addLast(10);
        mySingleList.addLast(90);
        mySingleList.addLast(30);
        mySingleList.addLast(40);
        mySingleList.addLast(15);
        mySingleList.addLast(50);
        mySingleList.addLast(15);
        mySingleList.display();//10 90 30 40 15 50 15

        mySingleList.createCycle();
        System.out.println(mySingleList.hasCycle());//判断是否有环

        MySingleList .Node cur =mySingleList.detectCycle();
        System.out.println(cur.getData());


//        MySingleList.Node cur = mySingleList.FindKthToTail(3);
//        System.out.println(cur.getData());


//        MySingleList.Node res =mySingleList.reverseList();
//        mySingleList.show(res);
//        mySingleList.show(mySingleList.reverseList());


//        mySingleList.clear();
//        Thread.sleep(1000);
//        System.out.println("hello bit");
//        mySingleList.removeAllKey(15);
//        mySingleList.display();
        //System.out.println(mySingleList.contains (30));
        //System.out.println(mySingleList.contains (18));
//        mySingleList.remove(10);
//        mySingleList.display();
//        mySingleList.remove(15);
//        mySingleList.display();
//        mySingleList.remove(30);
//        mySingleList.display();
    }
}
