class Solution {
    String[] numLetters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        return allPossibleCombinations(digits);

    }

    public List<String> allPossibleCombinations(String digits) {

        if (digits.length() == 1) {
            List<String> baseAns = new ArrayList<>();
            for (int i = 0; i < numLetters[digits.charAt(0) - '0'].length(); i++) {
                baseAns.add(numLetters[digits.charAt(0) - '0'].charAt(i) + "");
            }
            return baseAns;
        }

        List<String> partialAns = allPossibleCombinations(digits.substring(1, digits.length()));
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < partialAns.size(); i++) {

            for (int j = 0; j < numLetters[digits.charAt(0) - '0'].length(); j++) {

                ans.add(numLetters[digits.charAt(0) - '0'].charAt(j) + "" + partialAns.get(i));

            }
        }
        return ans;

    }
}
