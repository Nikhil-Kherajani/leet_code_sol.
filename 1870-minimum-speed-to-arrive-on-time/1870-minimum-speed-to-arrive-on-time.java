class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, h = 10000000, ans = -1;
        while(l <= h){
            int m = l + (h-l)/2;
            if(isans(dist , m, hour)){
                h = m - 1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }
    
    
    public int max(int[] arr){
        int max = arr[0];
        final int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
    public boolean isans(int[] a, int m, double hours){
        // boolean ans = false;

        double val = 0d;
        final int n = a.length;
        for(int i = 0; i < n ; i++){
            val += (double)a[i]/(double)m;
            if(i!= n-1){
                val = Math.ceil(val);
            }
            if(hours < val){
                return false;
            }
        }
        return true;
    }
    
    
    
    
    
    
}