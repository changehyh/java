
public class TestDemo1 {
//    public static boolean isValid(String S) {
// }

    public static void main(String[] args) {
        IMyQueueImpl iMyQueue =new IMyQueueImpl();
//        iMyQueue.push(10);
//        iMyQueue.push(20);
//        iMyQueue.push(30);
//        iMyQueue.push(40);
        System.out.println(iMyQueue.pop());//10
        System.out.println(iMyQueue.pop());//20
        System.out.println(iMyQueue.peek());//30
        System.out.println(iMyQueue.peek());//30

    }

    public static void main1(String[] args) {

        MyStackImpl myStack = new MyStackImpl(10);
//
//        myStack.push('(');
////        myStack.push('(');
//        myStack.push('[');
//        myStack.push('{');
//        myStack.push('}');
//        myStack.push(']');
//        myStack.push(')');


        String S = "(){}";
        System.out.println(myStack.isValid(S));



//        System.out.println(myStack.pop());//40
//        System.out.println(myStack.peek());//30
//        myStack.push(50);
//        System.out.println(myStack.peek());//50
//        System.out.println(myStack.pop());//50
//
//        System.out.println(myStack.pop());//30
//        System.out.println(myStack.pop());//20
//        System.out.println(myStack.pop());//10
//        System.out.println(myStack.pop());//抛出一个异常
   }
}
