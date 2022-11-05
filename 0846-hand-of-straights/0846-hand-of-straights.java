class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len % groupSize != 0)
            return false;
       
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1); // create frequency of given element
        }
    
        
        while(!map.isEmpty() ){
            int first = map.firstKey();
       
            for(int i = 0 ; i <  groupSize  ; i++){
                 
                if(!map.containsKey(first +i))
                    return false;
                
                if(map.containsKey(first + i)) {
                     map.put(first + i , map.get(first + i) -1);
                }
                
                if( map.get(first+i) == 0){
                    map.remove(first+i);
                }                                                                                
            }       
        } 
        
        return true;
    }
}