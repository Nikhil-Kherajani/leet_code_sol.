import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];
        for(int i = 0 ; i < numRows; i++){
            ans[i] = "";
        }
        String result = "";
        int word = 0;
        for (int j = 0; word < s.length(); j++) {
            for (int i = 0; i < numRows; i++) {
                if(word >= s.length()){
                    break;
                }
                ans[i] += s.charAt(word);
                word++;
            }
            for (int i = numRows - 2; i > 0; i--) {
                if(word >= s.length()){
                    break;
                }
                ans[i] += s.charAt(word);
                word++;
            }
        }
        for (int i = 0; i < numRows; i++) {
            result += ans[i];
        }

        return result;

    }
}