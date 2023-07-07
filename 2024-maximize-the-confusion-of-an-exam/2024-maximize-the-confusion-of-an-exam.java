import java.util.*;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        final int n = answerKey.length();
        char[] key = new char[n];
        int maxt = Integer.MIN_VALUE;
        int maxf = Integer.MIN_VALUE;

        key = answerKey.toCharArray();
        int l = 0, r = 0, s = 0, tk = 0;
        // TTFTTFTT

        while (r < n) {
            if (key[r] == 'T') {
                r++;
                s++;
            } else {
                if (tk >= k) {
                    maxt = Math.max(maxt, s);
                    while (key[l] != 'F') {
                        l++;
                        s--;
                    }
                    l++;
                    s--;
                    tk--;
                }
                r++;
                tk++;
                s++;
            }
            if (r == n) {
                maxt = Math.max(maxt, s);
            }
        }

        l = 0;
        r = 0;
        s = 0;
        tk = 0;
        while (r < n) {
            if (key[r] == 'F') {
                r++;
                s++;
            } else {
                if (tk >= k) {
                    maxf = Math.max(maxf, s);
                    while (key[l] != 'T') {
                        l++;
                        s--;
                    }
                    l++;
                    s--;
                    tk--;
                }
                r++;
                tk++;
                s++;
            }
            if (r == n) {
                maxf = Math.max(maxf, s);
            }
        }

        return Math.max(maxt, maxf);
    }
}
