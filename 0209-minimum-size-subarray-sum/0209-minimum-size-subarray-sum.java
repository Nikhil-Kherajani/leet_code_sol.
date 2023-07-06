class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        int l = 0, r = 0, min = Integer.MAX_VALUE, ans = 0;  
        ans += nums[l];
        while(l<=r){
            if(ans >= target){
                min = Math.min(r-l+1 , min);
                ans -= nums[l];
                l++;
            }
            else{
                if(r>= n){
                    if(ans < target){
                        return min == Integer.MAX_VALUE ? 0 : min;
                    }
                    
                }
                else{
                    r++;
                    if(r<n)
                    ans += nums[r];

                }
            }
            
        }
        return min;
    }
}