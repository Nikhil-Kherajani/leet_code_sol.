class Solution
{
public:
    string addBinary(string a, string b)
    {
        string s = "";
        
        int c = 0, i = a.size() - 1, j = b.size() - 1;
        while(i >= 0 || j >= 0 || c == 1)
        {
           if(i>=0) c+=a[i--]-'0';
           else c+=0;
          
          if(j>=0)c+=b[j--]-'0';
          else c+=0;
         
           
            s = char(c % 2 + '0')+s;
            c /= 2;
        }
        
        return s;
    }
};