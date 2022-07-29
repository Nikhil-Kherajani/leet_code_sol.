class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
       
        string s="";
		//store n into a string
        for(int i=0;i<32;i++)
            {
              if((n&1)==1){
                  s=s+'1';
                  
              }
            else{
                s=s+'0';
            }
                    n>>=1;
            }
			//for facility, reverse the string and keep on calculation it with multiplying with 2 with the last value
			//as like we calculate the decimal from binary
        reverse(s.begin(),s.end());
        
        uint32_t p=0;
        long long a=1;
        for(auto i:s){
            p=p+(a*(i-'0'));
            a=2*a;
        }
        
        return p;
    }
};