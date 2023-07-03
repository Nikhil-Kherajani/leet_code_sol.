class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        final int n = s.length();
        char[] alp = new char[26];
        char[] alp2 = new char[26];

        int ans = 0 , same = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != goal.charAt(i)){
                ans++;
            }
            alp[s.charAt(i) - 'a']++;
            alp2[goal.charAt(i) - 'a']++;
            
        }
        for(int i = 0 ; i < 26 ; i++){
            if(alp[i] >= 2){
                same = 2;
            }
            if(alp[i] != alp2[i]){
                return false;
            }
        }
        if(ans == 2){
          return true;  
        }
        else if(ans == 0 && same == 2){
            return true;
        }
        return false;
    }
}