class Solution {
    private char[] set = new char[3];
    private int count = 0; 
    private String ans = "";
    public String getHappyString(int n, int k) {
        set[0] = 'a'; set[1] = 'b' ; set[2] = 'c';
        char[] HappyString = new char[n];
        possibleHappyString(0 , HappyString , n , k);
        return ans;
    }
    
    public void possibleHappyString(int ind , char[] HappyString , int n, int k){
        
        if(ind == n){
            count++;
            if(k == count){
                String temp = new String(HappyString);
                // ans += String.toString(HappyString);
                ans+= temp;
            }
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++){
            if(ind == 0){
                HappyString[ind] = set[i];
                possibleHappyString(ind + 1 , HappyString, n , k);
            }
            else{
                if(HappyString[ind - 1] != set[i]){
                    HappyString[ind] = set[i];
                    possibleHappyString(ind + 1 , HappyString, n , k);
                }
            }
        }
        
    }
}