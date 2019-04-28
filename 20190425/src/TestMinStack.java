//实现一个最小栈
public class TestMinStack {
    private MyStackImpl myStack;
    private MyStackImpl minStack;

    public TestMinStack() {
        this.myStack = new MyStackImpl(10);
        this.minStack = new MyStackImpl(10);
    }

    //入栈  对两个栈都要入栈
    //	每次放入之前需要看最小栈
    //	的栈顶元素的值比较
    public void push(int x) {
        myStack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                //维持最小栈的最小值,也是栈的最小值
                minStack.push(x);
            }
        }
    }

    //出栈
    // 出栈不是出最小栈
    public void pop() {
        if (!myStack.empty()) {
            int data = myStack.pop();
            if (data == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    //返回栈顶元素
    public int top() {
        if (myStack.empty()) {
            return -1;
        } else return myStack.peek();
    }
    //返回栈最小元素
    public int getMin() {
        return minStack.peek();
    }
}
