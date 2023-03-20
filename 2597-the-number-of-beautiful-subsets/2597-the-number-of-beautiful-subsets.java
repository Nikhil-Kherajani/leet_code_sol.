class Solution {
    int map[];
    
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        map = new int[1003];
        
        return helper(0,k,nums)-1;
    }
    private int helper(int ind,int k,int[] nums){
        if (ind == nums.length) return 1;

        int taken = 0;
        if ((nums[ind] - k) < 0 || (map[nums[ind]-k] == 0)){
            map[nums[ind]]++;
            taken = helper(ind+1,k,nums);
            map[nums[ind]]--;
        }
        int not_taken = helper(ind+1,k,nums);
        return taken + not_taken;
    }
   
}