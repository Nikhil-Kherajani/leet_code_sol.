class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<words.length;i++) {
            String str = "";
            for(int j=0;j<words[i].length();j++) {
                str += code[words[i].charAt(j)-'a'];
            }
            set.add(str);
        }
        
        return set.size();
    }
}