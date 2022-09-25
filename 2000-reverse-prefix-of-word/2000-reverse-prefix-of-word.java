class Solution {
public String reversePrefix(String word, char ch) {
int k = word.indexOf(ch);
String s = word.substring(0,k+1);
StringBuilder st = new StringBuilder(s);
st.reverse();
s = st.toString();
return s+word.substring(k+1,word.length());
}
}