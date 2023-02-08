class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        
        int jump = 1, curr = nums[0], far = 0;
        
        
        for(int i = 0 ; i < nums.length ; i++){
            if(i > curr && curr > 0){
                curr = far;
                jump++;
            }
            far = Math.max(far , i + nums[i]);
        }
        return jump; 
    }
}