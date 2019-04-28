

public class MyStackImpl implements IMyStack {

    private int top;//永远指向可以存放数据元素的下标
    private int[] elem;//数组
    private int usedSize;//数据元素的个数

    public MyStackImpl(int size) {
        this.top = 0;
        this.elem = new int[size];
        this.usedSize = 0;
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // 将 item 压入栈中
    @Override
    public void push(int item) {
        if (isFull()) {
            throw new UnsupportedOperationException("栈以满");
        }
        this.elem[this.top++] = item;
        this.usedSize++;
    }

    // 返回栈顶元素，并且出栈
    @Override
    public int pop() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data = this.elem[this.top - 1];
        this.top--;
        this.usedSize--;
        return data;
    }

    // 返回栈顶元素，但不出栈
    @Override
    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top - 1];
    }

    // 判断这个栈是否为空栈
    @Override
    public boolean empty() {
        return this.top == 0;
    }

    // 返回元素个数
    @Override
    public int size() {
        return this.usedSize;
    }


    public boolean isValid(String S) {
        MyStackImpl myStack = new MyStackImpl(10);
        if (S.length() % 2 == 1){
            return false;
        }
        for (int i = 0; i < S.length(); i++) {
                if (myStack.empty()){
                    myStack.push(S.charAt(i));
                }else if ((myStack.peek()=='['&& S.charAt(i)==']')||
                        (myStack.peek()=='('&& S.charAt(i)==')')||
                        (myStack.peek()=='{'&& S.charAt(i)=='}')){
                    myStack.pop();
                }else {
                    myStack.push(S.charAt(i));
                    }
        }
        if (myStack.empty()){
            return true;
        }
        return false;
    }
}


