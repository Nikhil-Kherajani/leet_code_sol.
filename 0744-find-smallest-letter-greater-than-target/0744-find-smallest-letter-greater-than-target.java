class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length-1;
        int ans = letters[0];
        while(l<=h){
            int m = (h+l)/2 ;
            // System.out.println(letters[m]);

            if((int)target < (int)letters[m]){
                h = m;
                ans = (int)letters[m];
                if(l==h){
                    break;
                }
                
            }
            else{
                l = m+1;
                // ans = (int)letters[m];
            }
        }
        return (char)ans;
    }
}