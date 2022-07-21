class Solution {
public:
	int romanToInt(string s) {
		int ans = 0;
		for(int i = 0;i < s.size(); i++){
			if(s[i] == 'I' and (s[i+1] == 'V' or s[i+1] == 'X')){
				ans += -1;
			}
			else if(s[i] == 'I'){
				ans += 1;
			}
			else if(s[i] == 'V'){
				ans += 5;
			}
			else if(s[i] == 'X' and (s[i+1] == 'L' or s[i+1] == 'C')){
				ans += -10;
			}
			else if(s[i] == 'X'){
				ans += 10;
			}
			else if(s[i] == 'L'){
				ans += 50;
			}
			else if(s[i] == 'C' and (s[i+1] == 'D' or s[i+1] == 'M')){
				ans += -100;
			}
			else if(s[i] == 'C'){
				ans += 100;
			}
			else if(s[i] == 'D'){
				ans += 500;
			}
			else{
				ans += 1000;
			}
		}
		return ans;
	}
};