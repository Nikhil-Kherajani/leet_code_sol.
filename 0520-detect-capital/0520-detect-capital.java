class Solution {
    public boolean detectCapitalUse(String word) {
        boolean flag = false;
        boolean capital = false;
        if (word.charAt(0) < 91 && word.charAt(0) > 64) {
            capital = true;
        } else {
            capital = false;
        }
        if(word.length() > 1){
        if (capital) {
            if (word.charAt(1) < 91 && word.charAt(1) > 64) {
                flag = true;
            } else if (word.charAt(1) > 96 && word.charAt(1) < 123) {
                flag = false;
            }
        }
        else{
            if (!(word.charAt(1) > 96 && word.charAt(1) < 123)) {
                return false;
            }
        }
        }
        for (int i = 2; i < word.length(); i++) {
            if(capital){
            if (flag) {
                if (!(word.charAt(i) < 91 && word.charAt(i) > 64)) {
                    return false;
                }
            } else if (!flag) {
                if (!(word.charAt(i) > 96 && word.charAt(i) < 123)) {
                    return false;
                }
            }
            }
            if (!capital) {
                if (!(word.charAt(i) > 96 && word.charAt(i) < 123)) {
                    return false;
                }
            }

        }
        return true;
    }
}