class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int currentCounter;
    public SmallestInfiniteSet() {
        set = new TreeSet<Integer>();
        currentCounter = 1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty()){
            int top = set.first();
            set.remove(top);
            return top;
        }
        return currentCounter++;
    }
    
    public void addBack(int num) {
        if(num >= currentCounter)
            return;
        set.add(num);
    }
}