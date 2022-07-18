class Solution {
public:
    bool isNumber(string s) {        
        bool sign=1,dot=0,charE=0,digit=0;
        
        for(char c:s){
            if((c=='-' || c=='+') and sign){
                sign=false;
                continue;
            }
            
            sign=false;
            
            if(c == '.'){
                if(!charE and !dot){
                    dot=true;
                }
                else return false;
                continue;
            }
            
            if(c=='e' || c=='E'){
                if(!charE and digit)
                    charE=true;
                else return false;
                sign=true; // for 4e+6
                digit=false; // for 0e
                continue;
            }
            
            if(isdigit(c)){
                digit=true;
                continue;
            }
            
            return false;
        }
        return digit;
    }
};