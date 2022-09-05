class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b)); 
        String sum="";
        if(arr[0].equals("0")){
            return "0";
        }
        for(String f : arr){
            sum+=f;
        }
        return sum;
        
    }
}