import java.util.*;

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, n = s.length(), r = n - 1;
        boolean oneSkip = false;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {

                if (s.charAt(l + 1) == s.charAt(r)) {

                    break;
                } else if (s.charAt(l) == s.charAt(r - 1)) {

                    break;
                } else {
                    return false;
                }

            }
        }
        int cl = l;
        int cr = r;
        cr--;
        l++;
        boolean ans1 = true, ans2 = true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                ans1 = false;
            }
            l++;
            r--;
        }
        while (cl < cr) {
            if (s.charAt(cl) != s.charAt(cr)) {
                ans2 = false;
            }
            cl++;
            cr--;
        }
        return ans1 || ans2;
    }
}