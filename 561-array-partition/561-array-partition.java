class Solution {
    public int arrayPairSum(int[] nums) {
        int len=nums.length;
        int sum=0;
        Arrays.sort(nums);
        for(int i=len-2;i>=0;){
            sum+=nums[i];
            i=i-2;
        }
        return sum;
    }
}