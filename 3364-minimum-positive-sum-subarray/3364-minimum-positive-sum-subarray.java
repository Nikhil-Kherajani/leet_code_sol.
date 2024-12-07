class Solution {
    private int n;
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        n = nums.size();
        for(int i = 0; i < n; i++ ){
            int sum = 0;
            for(int j = i ; j <n ; j++){
                sum += nums.get(j);
                if((Math.abs(i-j)+1)>=l && (Math.abs(i-j)+1)<=r && sum > 0){
                    ans = Math.min(sum , ans);
                } 
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}