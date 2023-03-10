class Solution {
    // similar to koko eating banana 
    public int smallestDivisor(int[] nums, int threshold) {
        int h = Integer.MIN_VALUE;
        int ans = 0;
        for(int val : nums){
            h = Math.max(h , val);
        }
        
        int l = 1;
        while(l <= h){
            int m = l + (h - l)/2;
            if(sum(m , nums) <= threshold){
                ans = m;
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
        
    }
    
    public int sum(int d , int[] nums){
        int sum = 0;
        for(int val : nums){
            sum += (int)(Math.ceil(val*1d/ d));
        }
        return sum;
    }
}