class Solution {
public:
int strStr(string h, string n) {

    if(n.size()>h.size())
    {
      
        return -1;
    }
    for(int i=0;i<h.size();i++)
    {
        int j=0;
        for(j=0;j<n.size();j++)
        {
            if(h[j+i]!=n[j])
                break;
        }
        if(n.size()==j)
            return i;
    }
    return -1;
}
};