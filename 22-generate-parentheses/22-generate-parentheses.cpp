class Solution {
public:
    void help(int n,int op,int cl,string temp,vector<string>&res) {
    
        if(op==cl && cl==n)
        {
            res.push_back(temp);
            return;
        }
        
        if(op<n){
            help(n,op+1,cl,temp+"(",res);
        }
        if(cl<op){
            help(n,op,cl+1,temp+")",res);
        }
        
        
        
    }
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        help(n,1,0,"(",res);
        
        return res;
    }
};