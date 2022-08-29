class Solution {
    public int sumOddLengthSubarrays(int[] a) {
        int sum=0;int n=a.length;
        for(int i=0;i<n;i++){
            // finding total no of subarray containg a[i]
            int t=(i+1)*(n-i);
            // if we divide the total count than it will give us odd subarrays
            int cnt=(t+1)/2;
            sum+=(cnt*a[i]);
        }
        return sum;
    }
}