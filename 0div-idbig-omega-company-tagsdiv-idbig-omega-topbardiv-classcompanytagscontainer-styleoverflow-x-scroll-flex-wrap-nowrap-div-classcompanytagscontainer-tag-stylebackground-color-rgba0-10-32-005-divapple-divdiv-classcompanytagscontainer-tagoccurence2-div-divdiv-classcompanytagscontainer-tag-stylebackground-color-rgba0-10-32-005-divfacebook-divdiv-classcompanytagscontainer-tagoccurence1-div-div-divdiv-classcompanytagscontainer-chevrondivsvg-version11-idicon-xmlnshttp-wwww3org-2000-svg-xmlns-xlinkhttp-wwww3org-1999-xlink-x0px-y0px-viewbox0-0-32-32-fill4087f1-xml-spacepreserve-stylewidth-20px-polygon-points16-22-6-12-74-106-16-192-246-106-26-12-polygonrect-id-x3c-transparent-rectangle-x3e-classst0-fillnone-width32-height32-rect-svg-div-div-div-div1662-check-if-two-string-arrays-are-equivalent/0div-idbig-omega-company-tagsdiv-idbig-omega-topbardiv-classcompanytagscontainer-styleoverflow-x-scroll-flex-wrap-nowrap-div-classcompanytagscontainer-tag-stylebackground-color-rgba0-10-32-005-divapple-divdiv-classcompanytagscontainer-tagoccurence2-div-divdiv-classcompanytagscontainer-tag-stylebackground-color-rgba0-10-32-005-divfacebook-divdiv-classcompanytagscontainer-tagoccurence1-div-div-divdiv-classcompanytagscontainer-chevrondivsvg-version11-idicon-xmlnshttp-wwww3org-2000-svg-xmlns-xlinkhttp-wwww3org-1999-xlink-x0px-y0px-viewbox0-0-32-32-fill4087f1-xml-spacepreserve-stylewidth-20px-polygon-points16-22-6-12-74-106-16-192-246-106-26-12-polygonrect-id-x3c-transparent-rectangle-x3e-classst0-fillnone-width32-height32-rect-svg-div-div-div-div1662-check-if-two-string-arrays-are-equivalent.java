class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = "";        String b = "";

        for(int i = 0 ; i < word1.length ; i++){
            a += word1[i];
        }
        for(int i = 0 ; i < word2.length ; i++){
            b += word2[i];
        }
        if(a.length() != b.length()){
            return false;
        }
        int n = a.length();
        for(int i = 0 ;i < n ; i++){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }
}