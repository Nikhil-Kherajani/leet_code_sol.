class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];
        
        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }
        
        int ans = 1;
        for (int num = 2; num <= n; num++) {
            ans = Math.min(ans + counts[num], num);
        }
        
        return ans;
    }
}