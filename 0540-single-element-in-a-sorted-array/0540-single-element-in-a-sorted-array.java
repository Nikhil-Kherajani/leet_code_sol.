class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        final int n = nums.length; 
        int xor = 0;
        for(int i = 0 ; i < n ; i++){
            xor ^= nums[i];
        }
        return xor;
    }
}