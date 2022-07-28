class MyStack {
public:
    queue<int> q;
    void push(int x) {
        q.push(x);
        int size = q.size();
        for(int i = 0; i < size-1; i++){
            q.push(q.front());
            q.pop();
        }
    }
    
    int pop() {
        int x = top();
        q.pop();
        return x;
    }
    
    int top() {
        return q.front();
    }
    
    bool empty() {
        return q.empty();
    }
};