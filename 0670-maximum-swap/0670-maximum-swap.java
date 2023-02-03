import java.util.*;

class Solution {
    public int maximumSwap(int num) {
        String s = num + "";
        int i = 0;
        int index = 0;
        for (; i < s.length()-1; i++) {
            int max = s.charAt(s.length()-1) - '0';
            index = s.length()-1;
            for (int j = s.length()-1; j >= i+1; j--) {
                if ((s.charAt(j) - '0') > max) {
                    max = (s.charAt(j) - '0');
                    index = j;
                }
            }
            if ((s.charAt(i) - '0') < max) {
                break;
            }
        }
        char[] temp = s.toCharArray();
        char t = temp[i];
        temp[i] = temp[index];
        temp[index] = t;
        String ans = "";
        for (char ch : temp) {
            ans += ch;
        }

        return Integer.parseInt(ans);
    }
}