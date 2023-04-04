class Solution {
    public int partitionString(String s) {
        final int n = s.length();
        int ans = 0;
        int[] l = new int[26];
        for(int i = 0 ; i < n; i++){
            if(l[s.charAt(i) - 'a'] == 0){
                // System.out.println(s.charAt(i) );
                l[s.charAt(i) - 'a']++;
            }
            else{
                ans++;
                // System.out.println("else" + ( s.charAt(i)) );
                for(int j = 0 ; j < 26 ; j++){
                    l[j] = 0;
                }
                // System.out.println(" i = " + i);
                l[s.charAt(i) - 'a']++;
                // for(int val : l){
                //     System.out.print(val + " ");
                // }
            }
            if( i == n - 1){
                ans++;
            }
        }
        return ans;
    }
}