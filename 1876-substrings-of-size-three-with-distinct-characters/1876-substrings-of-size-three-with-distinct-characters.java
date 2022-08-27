class Solution {
    public int countGoodSubstrings(String s) {
	int c = 0, i = 2;
	while ( i < s.length() ) {
		if ( s.charAt(i) == s.charAt(i - 1) ) i+= 2;
		else if ( s.charAt(i - 1) == s.charAt(i - 2) || s.charAt(i) == s.charAt(i - 2) ) i += 1;
		else {
			c++;
			i += 1;
		}
	}
	return c;
}
}