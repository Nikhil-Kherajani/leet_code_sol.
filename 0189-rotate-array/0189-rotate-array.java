class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k==n){
            return;
        }
        else if(k > n){
            k = k % n;
        }
        int[] result = new int[n];
        int index = 0;
        int i;
        for(i = n - k ; i < n; i++ ){
            result[index] = nums[i];
            index++;
        }
        for(i = 0; i < n - k; i++){
            result[index] = nums[i] ;
            index++;
        }
        for(i = 0; i < n; i++){
            nums[i] = result[i];
        }
    }
}