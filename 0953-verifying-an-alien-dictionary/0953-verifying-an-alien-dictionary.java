class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] letters = new int[26];
        for (int i = 0; i < 26; i++) {
            letters[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (i + 1 < words.length && j < words[i + 1].length()
                        && letters[words[i].charAt(j) - 'a'] < letters[words[i + 1].charAt(j) - 'a']) {
                    break;
                } else if (i + 1 < words.length && j < words[i + 1].length()
                        && letters[words[i].charAt(j) - 'a'] == letters[words[i + 1].charAt(j) - 'a']) {
                    continue;
                } else if (i + 1 != words.length) {
                    return false;
                }
            }
        }
        return true;
    }
}