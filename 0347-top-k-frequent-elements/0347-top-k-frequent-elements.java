class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        
        
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        

        for(Integer i : map.keySet()){
            
            int key = i;
            int value = map.get(i);
            
            
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            
        
            bucket[value].add(key);
            
        }
        
        int[] result = new int[k];
        int counter = 0;
        int temp = k;
        
        
        for(int i=nums.length; i>=0; i--){
            
            if(bucket[i] != null){
                
                for(Integer j : bucket[i]){
                    
                    if(temp == 0){
                        break;
                    }
                    
                    result[counter] = (int)j;
                    
                    counter++;
                    
                    temp--;
                    
                }
            }
        }
        
        return result;
        
    }
}