class Solution {
    public int partitionDisjoint(int[] nums) {
        int count = 0, last = 1 , ans = 0;
        final int n = nums.length;
    
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[count]){
                ans = i;
                for(int j = last ; j < i; j++){
                    if(nums[j] > nums[count]){
                        count = j;
                        
                    }
                    last = j;
                }
            }
        }
        return ans + 1;
    }
}