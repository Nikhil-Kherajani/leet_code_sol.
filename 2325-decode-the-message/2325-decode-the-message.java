class Solution {
    public String decodeMessage(String key, String message) {
        String result = new String();
        HashMap<Character,Character> map = new LinkedHashMap<>();
        int n = key.length();
        int i = 0;
        int count = 0;
        int charInt = 97;
        while(i<n && count<26){
            if(Character.isLowerCase(key.charAt(i)) && (key.charAt(i) != ' ')){
                if(!map.containsKey(key.charAt(i))){
                    count++;
                    map.put(key.charAt(i),(char)charInt);
                    charInt++;
                }
            }
            i++;
        }
      n = message.length();
        i = 0;
        while(i < n){
            if(message.charAt(i) == ' '){
                result = result+" ";
            }
            else{
                result = result+Character.toString(map.get(message.charAt(i)));
            }
            i++;
        }
        return result;
    }
}