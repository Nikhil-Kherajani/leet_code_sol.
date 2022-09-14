class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {

        int count= 0;
        
        for(int i = 0; i < nums.length; ++i){
            int nextSum = nums[i] + diff;
            int firstIndex = Arrays.binarySearch(nums, i + 1, nums.length, nextSum);
            if(firstIndex > -1 && 
               Arrays.binarySearch(nums, firstIndex + 1, nums.length, nextSum + diff) > -1) {
                ++count;
            }
            
        }
        
        return count;
    }
}