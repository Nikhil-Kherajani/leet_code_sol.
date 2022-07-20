class Solution {
    
public:
    bool canContain(int *v1, int *v2){
        int n = 130;
        for(int i=0;i<n;i++)
            if(v1[i] > v2[i])
                return false;
		
        return true;
    }
    
    string minWindow(string s, string t) {
        int n = s.length(), k = t.length(), i, j, minI = -1, minJ= 1000000;
        
        int charCountT[130];
        int charCountS[130];
        
        memset(charCountT, 0, sizeof(charCountT));
        memset(charCountS, 0, sizeof(charCountS));
        
        for(i=0;i<k;i++)
            charCountT[t[i]-'A']++;
        
        j = 0;
        i=0;
        bool flag = false;
        while(j<n && i<n){
            charCountS[s[j]-'A']++;
            flag = canContain(charCountT, charCountS);
            while(flag && i<=j){
                if(j-i<minJ-minI)
                {
                    minI = i;
                    minJ = j;
                }
                charCountS[s[i]-'A']--;
                if(charCountS[s[i]-'A'] >= charCountT[s[i]-'A'])
                    flag = true;
                else  
                    flag = false;
                i++;
            }
            j++;
        }
        
        if(minI!=-1)
            return s.substr(minI, minJ-minI+1);
        else
            return "";
    }
};