class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l  = 1, h = arr.length - 2;
        while(l<= h){
            int m = l + (h-l)/2;
            if(arr[m-1]<arr[m] && arr[m+1]<arr[m]){
                return m;
            }
            else if(arr[m]>arr[m+1]){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return 555;
    }
}