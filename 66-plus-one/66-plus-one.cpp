class Solution {
public:
    vector<int> plusOne(vector<int>& d) {
        int n = d.size()-1;
        if(d[n]!=9)
        {
            d[n]+=1;
            return d;
        }
        while(n>=0)
        {
            if(n!=0 && d[n]== 9) d[n]=0;
            else if(n == 0 && d[n]== 9)
            {
                d[n]=0;
                d.insert(d.begin(),1);
            }
            else
            {
                d[n] +=1;
                break;
            }
            n--;
        }
        return d;
        
    }
};