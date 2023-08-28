class MyStack {
    // declare ArrayList
    public ArrayList<Integer> stack;

    public MyStack() {
    // Initialize ArrayList
      this.stack = new ArrayList<Integer>();    
    }
    
    public void push(int x) {
        // here we add elements to ArrayList
        this.stack.add(x);
    }
    
    public int pop() {
        // here we remove last element and return it
        return this.stack.remove(this.stack.size() - 1);
    }
    
    public int top() {
        // here we return top element
        return this.stack.get(this.stack.size() - 1);
    }
    
    public boolean empty() {
        // here we check if stack is empty
        return this.stack.size() == 0 ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */