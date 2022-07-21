class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        int minlen=0, counter=1;
        string s="";
        
        //get length of the minimum string
        for(int i=0; i<strs.size(); i++){
            if(strs[i].length()>minlen) minlen = strs[i].length();
        }
        
        for(int i=0; i<minlen; i++){
            char check = strs[0][i];
            for(int j=0; j<strs.size(); j++){
                if(strs[j][i]!=check) counter =0;
            }
            
            if(counter) s += check;
            else break;
        }
        return s;
        
    }
};