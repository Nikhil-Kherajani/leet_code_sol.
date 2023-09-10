class Solution {
    public int countOrders(int n) {
        
        int space=2*n;
        long ans=1;

        while(space>0)
        {
            ans=(ans* ((space*(space-1))/2))%1000000007;
            space-=2;
        }

        return (int)ans;
    }
    

    
}