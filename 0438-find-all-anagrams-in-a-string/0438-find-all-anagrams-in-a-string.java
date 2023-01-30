import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        int[] win = new int[26];
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        for (int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
            win[s.charAt(i) - 'a']++;
        }
        if (isSame(letters, win)) {
            ans.add(0);
        }
        int k = 0;
        for (int i = p.length(); i < s.length(); i++) {
            win[s.charAt(k) - 'a']--;
            win[s.charAt(i) - 'a']++;
            if (isSame(letters, win)) {
                ans.add(k + 1);
            }
            k++;
        }

        return ans;
    }

    public boolean isSame(int[] letters, int[] win) {
        for (int i = 0; i < 26; i++) {
            if (letters[i] != win[i]) {
                return false;
            }
        }
        return true;
    }
}