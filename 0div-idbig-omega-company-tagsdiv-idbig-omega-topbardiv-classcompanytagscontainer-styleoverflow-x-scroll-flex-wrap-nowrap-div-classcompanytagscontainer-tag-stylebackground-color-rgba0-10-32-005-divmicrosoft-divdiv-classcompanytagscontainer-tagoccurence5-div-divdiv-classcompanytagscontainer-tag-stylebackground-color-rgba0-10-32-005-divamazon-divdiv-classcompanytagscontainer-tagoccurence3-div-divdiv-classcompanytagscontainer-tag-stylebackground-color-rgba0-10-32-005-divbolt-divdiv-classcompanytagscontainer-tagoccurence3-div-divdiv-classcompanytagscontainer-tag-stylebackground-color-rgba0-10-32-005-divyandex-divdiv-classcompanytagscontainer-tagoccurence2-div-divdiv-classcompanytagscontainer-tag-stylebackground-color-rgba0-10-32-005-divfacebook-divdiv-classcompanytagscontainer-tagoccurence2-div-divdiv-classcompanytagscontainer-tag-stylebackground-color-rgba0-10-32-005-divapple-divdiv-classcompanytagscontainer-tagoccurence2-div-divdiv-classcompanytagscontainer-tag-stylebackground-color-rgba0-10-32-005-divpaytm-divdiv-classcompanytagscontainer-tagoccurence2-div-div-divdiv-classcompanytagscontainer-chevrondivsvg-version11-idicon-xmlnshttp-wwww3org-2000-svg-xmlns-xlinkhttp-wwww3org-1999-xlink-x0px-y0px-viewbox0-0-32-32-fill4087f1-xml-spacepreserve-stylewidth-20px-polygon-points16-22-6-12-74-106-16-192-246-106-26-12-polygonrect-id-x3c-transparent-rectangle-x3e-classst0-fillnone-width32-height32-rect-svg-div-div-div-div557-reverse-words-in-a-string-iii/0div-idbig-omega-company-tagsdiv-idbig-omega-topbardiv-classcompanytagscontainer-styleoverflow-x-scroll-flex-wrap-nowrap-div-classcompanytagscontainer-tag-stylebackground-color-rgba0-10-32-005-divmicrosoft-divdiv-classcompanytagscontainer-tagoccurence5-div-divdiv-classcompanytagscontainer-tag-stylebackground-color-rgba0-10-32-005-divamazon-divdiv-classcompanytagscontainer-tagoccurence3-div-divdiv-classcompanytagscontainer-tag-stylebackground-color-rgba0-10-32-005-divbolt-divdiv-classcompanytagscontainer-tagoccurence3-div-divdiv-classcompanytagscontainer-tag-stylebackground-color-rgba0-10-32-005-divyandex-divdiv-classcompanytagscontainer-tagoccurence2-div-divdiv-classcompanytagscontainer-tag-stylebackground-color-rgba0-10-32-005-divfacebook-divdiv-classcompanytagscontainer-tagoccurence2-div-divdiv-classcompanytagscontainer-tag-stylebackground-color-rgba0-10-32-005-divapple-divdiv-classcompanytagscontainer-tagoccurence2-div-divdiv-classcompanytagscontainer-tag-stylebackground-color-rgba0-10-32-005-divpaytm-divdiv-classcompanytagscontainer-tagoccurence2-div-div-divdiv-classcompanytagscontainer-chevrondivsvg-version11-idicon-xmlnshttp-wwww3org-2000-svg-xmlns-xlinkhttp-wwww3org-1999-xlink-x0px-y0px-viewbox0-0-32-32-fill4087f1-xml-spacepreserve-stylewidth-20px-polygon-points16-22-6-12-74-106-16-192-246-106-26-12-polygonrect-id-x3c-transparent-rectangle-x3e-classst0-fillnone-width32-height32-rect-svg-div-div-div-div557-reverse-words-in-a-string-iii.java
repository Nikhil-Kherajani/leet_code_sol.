class Solution {
public String reverse(String s){
StringBuilder reverseString = new StringBuilder(s);
reverseString.reverse();
String result = reverseString.toString();
return result;
}
public String reverseWords(String s) {
String[] words = s.split(" ");
StringBuilder ans = new StringBuilder("");
for(int i = 0;i<words.length;i++){
ans.append(reverse(words[i]));
ans.append(" ");
}
ans.delete(ans.length()-1,ans.length());
String result = ans.toString();
return result;
}
}