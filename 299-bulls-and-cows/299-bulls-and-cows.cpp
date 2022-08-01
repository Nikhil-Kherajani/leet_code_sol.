class Solution {
public:
    string getHint(string secret, string guess) {
        unordered_map<char, int> mps;
        unordered_map<char, int> mpg;
        unordered_map<char, int>::iterator it, tmp;
        int x = 0, y = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret[i] == guess[i]) {
                x++;
            }
            else {
                mps[secret[i]]++;
                mpg[guess[i]]++;    
            }    
        }
        for (it = mps.begin(); it != mps.end(); it++) {
            tmp = mpg.find(it->first);
            if (tmp != mpg.end()) {
                while (it->second != 0 && tmp->second != 0) {
                    it->second--;
                    tmp->second--;
                    y++;    
                }
            }
        }
        // cout << x << ", " << y << endl;
        return to_string(x) + 'A' + to_string(y) + 'B';
    }
};