class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resDiff = Integer.MAX_VALUE;
        int resSum = -1;
        
        for(int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                
                if(diff < resDiff){
                    resDiff = diff;
                    resSum = sum;
                }
                
                if(sum == target) return resSum;
                else if(sum < target) left++;
                else right--;
            }
        }
        return resSum;
    }
}