class Solution {
    public:
        inline int lengthOfLastWord(const string s) const {
            short len = s.length() - 1;
            unsigned short ret = 1;
            
            while((len >= 0) && (s[len--] == ' '));
            while((len >= 0) && (s[len--] != ' ')) ++ret;
            
            return ret;
        }
};