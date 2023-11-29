public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String a = Integer.toBinaryString(n) + "";
        // System.out.println(n);
        int ans = 0;
        for(int i = 0;i < a.length() ; i++){
            // System.out.println(a.charAt(i));
            if(a.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;
    }
}