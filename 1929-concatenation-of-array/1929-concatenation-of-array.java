class Solution {
    public int[] getConcatenation(int[] nums) {
        int []a=new int[2*nums.length];
        int b=0;
        for(int i=0;i<2;i++){
            for(int k:nums){
                a[b]=k;
                b++;
            }
        }
        return a;
    }
}