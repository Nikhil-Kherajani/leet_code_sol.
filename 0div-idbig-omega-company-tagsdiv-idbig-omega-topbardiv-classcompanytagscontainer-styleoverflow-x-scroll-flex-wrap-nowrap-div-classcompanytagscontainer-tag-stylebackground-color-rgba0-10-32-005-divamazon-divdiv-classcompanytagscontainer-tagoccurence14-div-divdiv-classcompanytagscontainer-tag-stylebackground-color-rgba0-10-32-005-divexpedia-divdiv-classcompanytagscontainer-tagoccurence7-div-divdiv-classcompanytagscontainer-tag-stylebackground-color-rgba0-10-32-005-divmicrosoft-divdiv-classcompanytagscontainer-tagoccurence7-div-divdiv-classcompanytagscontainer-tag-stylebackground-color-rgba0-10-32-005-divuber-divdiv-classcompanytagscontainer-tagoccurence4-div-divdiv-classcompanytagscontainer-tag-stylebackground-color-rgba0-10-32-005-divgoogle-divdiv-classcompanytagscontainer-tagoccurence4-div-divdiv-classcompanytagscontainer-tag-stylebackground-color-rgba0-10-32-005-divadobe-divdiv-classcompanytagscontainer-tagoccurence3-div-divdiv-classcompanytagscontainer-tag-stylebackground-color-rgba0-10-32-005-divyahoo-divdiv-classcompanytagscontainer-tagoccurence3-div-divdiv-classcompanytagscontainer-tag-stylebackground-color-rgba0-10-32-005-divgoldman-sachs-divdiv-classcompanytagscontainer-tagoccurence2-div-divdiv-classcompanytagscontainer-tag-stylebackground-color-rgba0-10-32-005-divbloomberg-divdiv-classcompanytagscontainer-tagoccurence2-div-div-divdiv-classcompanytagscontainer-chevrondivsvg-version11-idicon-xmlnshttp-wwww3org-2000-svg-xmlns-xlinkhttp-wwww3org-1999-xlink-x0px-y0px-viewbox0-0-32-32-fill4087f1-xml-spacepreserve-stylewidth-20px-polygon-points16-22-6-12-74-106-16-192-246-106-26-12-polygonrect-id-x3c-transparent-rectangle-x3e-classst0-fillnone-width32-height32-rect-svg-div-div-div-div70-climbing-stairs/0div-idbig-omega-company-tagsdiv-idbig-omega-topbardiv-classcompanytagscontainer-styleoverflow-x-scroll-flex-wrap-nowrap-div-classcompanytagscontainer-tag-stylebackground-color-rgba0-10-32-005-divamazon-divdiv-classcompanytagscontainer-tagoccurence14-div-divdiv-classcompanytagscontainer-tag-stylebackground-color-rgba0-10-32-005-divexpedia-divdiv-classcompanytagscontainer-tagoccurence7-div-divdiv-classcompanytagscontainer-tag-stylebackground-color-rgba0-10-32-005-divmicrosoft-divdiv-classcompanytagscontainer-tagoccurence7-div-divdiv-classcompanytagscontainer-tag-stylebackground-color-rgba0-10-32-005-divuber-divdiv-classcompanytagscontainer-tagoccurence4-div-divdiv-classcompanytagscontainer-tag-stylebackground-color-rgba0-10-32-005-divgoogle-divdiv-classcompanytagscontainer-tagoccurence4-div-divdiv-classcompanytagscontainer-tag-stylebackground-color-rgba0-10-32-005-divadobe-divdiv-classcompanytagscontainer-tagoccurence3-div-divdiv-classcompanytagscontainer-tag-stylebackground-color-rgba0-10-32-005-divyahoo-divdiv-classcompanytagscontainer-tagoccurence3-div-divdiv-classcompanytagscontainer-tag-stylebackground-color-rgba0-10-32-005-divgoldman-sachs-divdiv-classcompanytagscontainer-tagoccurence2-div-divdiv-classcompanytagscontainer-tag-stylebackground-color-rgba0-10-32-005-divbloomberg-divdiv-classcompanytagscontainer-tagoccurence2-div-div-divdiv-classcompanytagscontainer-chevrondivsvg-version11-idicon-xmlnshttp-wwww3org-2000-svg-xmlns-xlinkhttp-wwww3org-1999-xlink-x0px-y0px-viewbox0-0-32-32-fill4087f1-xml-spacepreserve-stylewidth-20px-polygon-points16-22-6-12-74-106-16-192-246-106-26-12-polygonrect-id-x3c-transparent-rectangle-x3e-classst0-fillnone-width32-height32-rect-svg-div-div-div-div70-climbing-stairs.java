class Solution {
    // private int ans = 0;
    private int[] v ;
    public int climbStairs(int n) {
        v = new int[n + 1];
        Arrays.fill(v , -1);
        return climb(0 , n);
        // return ans;
    }
    
    public int climb(int i , int n){
        if(i > n){
            return 0;
        }
        if(v[i] != -1){
            return v[i];
        }
        if(i == n){
            // ans++;
            return 1;
        }
    
        
        int one = climb(i + 1 , n);
        int two = climb(i + 2 , n);
        return v[i] = one + two;
    }
    
}