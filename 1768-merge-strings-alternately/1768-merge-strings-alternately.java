import java.util.*;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        final int n = word1.length(), m = word2.length();
        while (i < n && j < m) {
            str.append(word1.charAt(i));
            str.append(word2.charAt(j));
            i++;
            j++;
        }
        while (i < n) {
            str.append(word1.charAt(i++));
            
        }
        while (j < m) {
            str.append(word2.charAt(j++));
        }
        return str.toString();
    }
}