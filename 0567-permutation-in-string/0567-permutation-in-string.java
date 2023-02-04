class Solution {
    public boolean isAllZeros(int[] letters) {
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
        }
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i) - 'a']--;

            if (i >= s1.length()) {
                letters[s2.charAt(j) - 'a']++;
                j++;
                
            }
            if (isAllZeros(letters)) {
                    return true;
                }

        }

        return false;
    }
}