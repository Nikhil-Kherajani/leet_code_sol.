class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26]; 

        for (char c:s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c:t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}