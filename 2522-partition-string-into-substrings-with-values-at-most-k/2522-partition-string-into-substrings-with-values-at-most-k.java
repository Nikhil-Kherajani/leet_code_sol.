import java.util.*;

class Solution {
    public int minimumPartition(String s, int k) {

        if (k < 9) {
            for (int i = 0; i < s.length(); i++) {
                // System.out.println((int) (s.charAt(i)));
                if (((int) (s.charAt(i)) - '0') > k) {
                    return -1;
                }
            }
            return s.length();
        }

        int t = 9, c = 1;
        while (t < k) {
            t *= 11;
            c++;
        }
        // System.out.println(c);
        int ans = 0;
        for (int i = 0; i < s.length();) {
            boolean flag = false;
            int pi = i;
            // System.out.println("i = " + i);

            int j = i + 1;
            int r = 0;
            while (r <= c && j <= s.length() && j-pi <=9) {
               
                if (Integer.parseInt(s.substring(pi, j)) <= k) {
                     System.out.println(Integer.parseInt(s.substring(pi, j)));
                    flag = true;
                    i++;
                }
                j++;
                r++;
            }
            if (!flag)
                i++;
            // System.out.println(i);
            ans++;

        }

        return ans;
    }
}