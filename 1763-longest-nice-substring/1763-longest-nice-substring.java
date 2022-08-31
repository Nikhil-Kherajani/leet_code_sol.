class Solution {
    public String longestNiceSubstring(String s) {
        String str="";
        int max=0;
        for(int i=0; i<s.length(); i++){
            int[] arr1=new int[26];
            int[] arr2=new int[26];
            for(int j=i; j<s.length(); j++){
                int k=s.charAt(j);
                if(k<97){ arr1[k-65]=1; }
                else{ arr2[k-97]=1; }
                if(isTrue(arr1,arr2) && (j-i+1)>max){ max=j-i+1; str=s.substring(i,j+1); }
            }
        }
        return str;
    }
    public boolean isTrue(int[] arr1,int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i]!=arr2[i]){ return false; }
        }
        return true;
    }
}