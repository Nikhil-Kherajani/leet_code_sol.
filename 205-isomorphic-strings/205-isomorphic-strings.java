class Solution {
    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        if (slen != tlen) return false;
        
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        
        int index = 0;
        while (index < slen) {
            char c1 = s.charAt(index);
            char c2 = t.charAt(index);
            
            if (sMap.containsKey(c1) && sMap.get(c1) != c2) return false;
            
            if (tMap.containsKey(c2) && tMap.get(c2) != c1) return false;
            
            sMap.put(c1, c2);
            tMap.put(c2, c1);
            index += 1;
        }
        
        return true;
    }
}
