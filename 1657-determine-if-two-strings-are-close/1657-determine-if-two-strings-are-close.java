class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] a = new int[125];
        int[] b = new int[125];
        if(word1.length() == word2.length()){
            for(int i = 0 ; i< word1.length(); i++){
                a[word1.charAt(i)]++;
            }
            for(int i = 0 ; i< word2.length(); i++){
                b[word2.charAt(i)]++;
            }
            
            for(int i = 0 ; i<125 ; i++){
                if(a[i] > 0){
                    if(!(b[i] > 0)){
                        return false;
                    } 
                }
                if(b[i] > 0){
                    if(!(a[i] > 0)){
                        return false;
                    } 
                }
            }
            
        Arrays.sort(a);Arrays.sort(b);
        for(int i=0;i<125;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
        
        }
        else
            return false;
    }
}