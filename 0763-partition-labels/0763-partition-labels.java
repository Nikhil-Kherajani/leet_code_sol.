import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[] endIndex = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            if (endIndex[s.charAt(i) - 'a'] == 0) {
                endIndex[s.charAt(i) - 'a'] = i;
            }
        }
        int i = 0;
        int k = 0;
        while (i < n) {
            for (int j = i; j <= k; j++) {
                k = Math.max(endIndex[s.charAt(j) - 'a'], k);
            }
            ans.add(k - i + 1);
            i = k + 1;
            k++;
        }
        return ans;
    }
}