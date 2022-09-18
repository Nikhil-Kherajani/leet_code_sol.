class Solution {
    public int balancedStringSplit(String s) 
    {
        int ans =0, sum =0;
        
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            if(ch == 'R')
                sum++;
            else
                sum--;
            
            if(sum == 0)
                ans++;
        }
        return ans;
    }
}