class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] output = new int[101];  //constraints given 0 to 100
        //    1.    first count all the no of occurences;
        for(int i=0; i<nums.length; i++){
            output[nums[i]]++;
        }
        
        //        2. add all the previous + current element number.
        for(int i=1;i<output.length;i++){
            output[i] +=output[i-1];
        }
        
        //        3.set the previous count to the original array
        for(int i=0; i<nums.length;i++){
            int current = nums[i];
            if(current == 0) nums[i] =0;
            else{
                nums[i] = output[current-1];
            }
        }
        
        return nums;
    }
}
