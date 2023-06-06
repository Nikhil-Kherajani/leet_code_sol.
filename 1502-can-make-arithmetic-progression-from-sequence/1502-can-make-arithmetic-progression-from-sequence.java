class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        final int n = arr.length;
        int dif = arr[1] - arr[0];
        for(int i = 1 ; i < n ;i++){
            if(arr[i] - arr[i-1] != dif){
                return false;
            }
        }
        return true;
            
    }
}