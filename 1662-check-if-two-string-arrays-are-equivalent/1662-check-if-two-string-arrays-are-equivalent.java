class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb1.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++){
            sb2.append(word2[i]);
        }
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        if(str1.equals(str2)){
            return true;
        } 
        return false;
    }
}