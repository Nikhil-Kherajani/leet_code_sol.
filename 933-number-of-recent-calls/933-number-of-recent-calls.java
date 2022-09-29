class RecentCounter {
    Queue<Integer> q;
    int min;
    public RecentCounter() {
        q = new LinkedList<Integer>();
    }
    
    public int ping(int t) {        
        q.offer(t);
        min = t-3000;       
        while(min>q.peek()){
            q.poll();
        }
        return q.size();        
    }
}