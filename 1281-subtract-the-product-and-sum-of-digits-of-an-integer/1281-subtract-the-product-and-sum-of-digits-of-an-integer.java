class Solution {
    public int subtractProductAndSum(int n) {
        
        int cn1 = n ;
        int cn2 = n ;
        int p = 1 , sum = 0 ;
        while(cn1 > 0){
            sum = sum + (cn1 % 10);
            cn1 = cn1 / 10 ;
            
        }
        while(cn2 > 0){
            p = p * (cn2 % 10);
            cn2 = cn2 / 10 ;
            
        }
        
        int ans = p - sum ;
        return ans ;
        
    }
}