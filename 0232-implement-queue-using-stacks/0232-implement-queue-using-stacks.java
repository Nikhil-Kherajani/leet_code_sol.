class MyQueue {
    Stack<Integer> stackMain;
    Stack<Integer> stackReverse;

    public MyQueue() {
        stackMain = new Stack<>();
        stackReverse = new Stack<>();
    }
    
    public void push(int x) {
        stackMain.push(x);
    }
    
    public int pop() {
        copyStackFirstToTwo(stackMain, stackReverse);
        int result = stackReverse.pop();
        copyStackFirstToTwo(stackReverse, stackMain);
        return result;
    }
    
    public int peek() {
        copyStackFirstToTwo(stackMain, stackReverse);
        int result = stackReverse.peek();
        copyStackFirstToTwo(stackReverse, stackMain);
        return result;
    }

    private void copyStackFirstToTwo(Stack<Integer> one, Stack<Integer> destination) {
        while (!one.empty()) {
            destination.push(one.pop());
        }
    }
    
    public boolean empty() {
        return stackMain.empty();
    }
}