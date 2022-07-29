class Solution {
public:
    bool isHappy(int n) {
            
      while(!(n>1&&n<=9))
      {
              int num=0;
              //sum the squares of digit
              while(n!=0)
                  num+=pow((n%10),2),n=n/10;
              
              n=num;
              if(n==1)
                      return 1;
      }
            // for 7 it was true 
            if(n==7)
                return 1;
            else
                return 0;
            
    }
};