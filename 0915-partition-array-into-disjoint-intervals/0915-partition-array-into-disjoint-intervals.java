class Solution {
    public int partitionDisjoint(int[] nums) {
        int count = 0, last = 1 , ans = 0;
        boolean andrgyatha = false;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < nums[count]){
                ans = i;
                for(int j = last ; j < i; j++){
                    andrgyatha = true;
                    if(nums[j] > nums[count]){
                        count = j;
                        
                    }
                    last = j;
                }
                // if(andrgyatha){
                //     last = i;
                // }
            }
        }
        return ans + 1;
    }
}