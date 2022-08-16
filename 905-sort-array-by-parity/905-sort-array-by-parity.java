class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n= nums.length;
        int [] res= new int[n];
        int f=0,l=n-1;
        for(int x:nums){
            if(x%2==0){
                res[f]=x;
                f++;
            }else{
                res[l]=x;
                l--;
            }
        }
        return res;
    }
}