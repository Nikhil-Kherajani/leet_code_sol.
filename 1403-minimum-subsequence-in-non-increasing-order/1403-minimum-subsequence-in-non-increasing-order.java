class Solution {
    
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int totalSum = 0;
        
        for(int val : nums) totalSum += val;
        
        int maxSum = 0;
        for(int i = n - 1; i >= 0; i--){
            maxSum += nums[i];
            totalSum -= nums[i];
            result.add(nums[i]);
            if(maxSum > totalSum) break;
        }
        
        return result;
    }
}