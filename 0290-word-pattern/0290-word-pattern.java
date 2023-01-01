import java.util.HashMap;
import java.util.*;

class Solution {

    boolean wordPattern(String pattern, String s) {
        int count = 0;
        HashMap<String, Character> hm = new HashMap<>();
        int[] c = new int[125];
        int k = 0;
        for (int i = 0; i < pattern.length(); i++) {
            String temp = "";
            if(k == s.length()){
                return false;
            }
            for (int j = k; j < s.length(); j++) {
                k++;
                if (s.charAt(j) != ' ')
                    temp += s.charAt(j);
                else
                    break;
            }
            count++;
            // System.out.println(c[pattern.charAt(i)]);
            if (!hm.containsKey(temp)) {
                if (c[pattern.charAt(i)] == 0)
                    hm.put(temp, pattern.charAt(i));
                else
                    return false;
                c[pattern.charAt(i)]++;
            } else {
                if (hm.get(temp) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        System.out.println(k);
        if(k!=s.length())
            return false;
        
        return true;
    }
};