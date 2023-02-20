class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        final int n = nums.length;
        int h = n - 1;
        while( l <= h ){
            int m = (l + h) / 2;
            if(nums[m] > target){
                h = m - 1;
            }
            else if(nums[m] < target){
                l = m + 1;
            }
            else{
                return m;
            }
        }
        if(l >= 0 && l < n && nums[l] < target){
            return l+1;
        }
        return h + 1;
    }
}