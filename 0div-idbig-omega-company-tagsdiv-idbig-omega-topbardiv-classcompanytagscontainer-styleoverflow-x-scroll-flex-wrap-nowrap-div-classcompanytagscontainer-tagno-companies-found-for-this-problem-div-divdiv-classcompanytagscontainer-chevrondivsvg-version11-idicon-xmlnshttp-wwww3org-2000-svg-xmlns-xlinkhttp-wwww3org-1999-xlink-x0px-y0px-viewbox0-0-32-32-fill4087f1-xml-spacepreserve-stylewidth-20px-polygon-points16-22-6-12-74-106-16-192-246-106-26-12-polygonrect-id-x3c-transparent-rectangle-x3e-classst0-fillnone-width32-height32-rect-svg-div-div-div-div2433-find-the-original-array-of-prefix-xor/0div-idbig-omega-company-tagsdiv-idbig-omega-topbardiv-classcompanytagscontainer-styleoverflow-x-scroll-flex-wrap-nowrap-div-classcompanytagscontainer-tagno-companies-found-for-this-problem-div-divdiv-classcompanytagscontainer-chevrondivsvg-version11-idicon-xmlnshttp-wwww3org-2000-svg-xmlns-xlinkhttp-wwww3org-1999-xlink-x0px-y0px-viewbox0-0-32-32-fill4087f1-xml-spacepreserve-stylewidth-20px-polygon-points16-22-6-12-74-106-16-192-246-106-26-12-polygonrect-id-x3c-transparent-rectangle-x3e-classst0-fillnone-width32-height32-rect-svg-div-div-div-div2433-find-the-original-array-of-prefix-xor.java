class Solution {
    public int[] findArray(int[] pref) {
        int[] a  = new int[pref.length] ;
        a[0] = pref[0];
        for(int i = 1 ; i < pref.length ; i++){
            a[i] = pref[i-1] ^ pref[i]; 
        }
        return a;
    }
    
}