public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int pointer;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        pointer = 0;
        list = new ArrayList<>();
        getList(list, nestedList);
        
    }
    
    public void getList(List<Integer> list, List<NestedInteger> nestedList) {
        for(int i=0; i<nestedList.size(); i++) {
            NestedInteger temp = nestedList.get(i);
            if(temp.isInteger())
                list.add(temp.getInteger());
            else {
                getList(list, temp.getList());
            }
        }
    }
    

    @Override
    public Integer next() {
        return list.get(pointer++);
    }

    @Override
    public boolean hasNext() {
        if(pointer < list.size())
            return true;
        else
            return false;
    }
}
