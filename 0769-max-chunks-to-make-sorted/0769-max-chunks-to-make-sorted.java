class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0 , end = 0;
        final int n = arr.length;
        for(int i = 0 ;i < n ; i++){
            
            if(arr[i] == i){
                ans++;
            }
            else{
                end = arr[i];
                for(;i <= end ;i++){
                    if(arr[i] > end){
                        end = arr[i];
                    }
                }
                i--;
                ans++;
            }
        }
        return ans;
    }
}