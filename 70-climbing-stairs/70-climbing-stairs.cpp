class Solution {
public:
    int climbStairs(int n) {
        int ans=0, s1=1, s2=2;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        
        for (int i=2;i<n;i++) {
            ans=s1+s2;
            s1=s2;
            s2=ans;
        }
        
        return ans;
    }
};