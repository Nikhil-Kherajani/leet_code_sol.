class Solution {
public:
    string normalJustification(vector<string>& words, int maxWidth) {
        int noOfChar = 0;
        for (auto word : words) {
            noOfChar += word.size();
        }
        int rem = maxWidth - noOfChar;
        int forEachWord = 0;
        forEachWord = rem/(words.size() - 1);

        rem = rem % (words.size() - 1);
        
        string ret;
        for (int i = 0; i < words.size(); ++i) {
            auto& curr = words[i];
            ret += curr;
            if (i != words.size() - 1) {
                ret+=string(forEachWord, ' ');
                if (rem){
                    ret+=' ';
                    rem--;
                }
            }
        }
        return ret;
    }
    
    string leftJustification(vector<string>& words, int maxWidth) {
        int noOfChar = 0;
        for (auto word : words) {
            noOfChar += word.size();
        }
        int rem = maxWidth - noOfChar;
        string ret;
        if (words.size() == 1)
            return words[0] + string(rem, ' ');
        for (int i = 0 ; i < words.size(); ++i) {
            ret += words[i];
            if (i != words.size() - 1){
                ret += ' ';
                rem --;
            }
        }
        ret += string(rem, ' ');
        return ret;
    }
    string parseTheLine(vector<string>& words, int maxWidth, bool lastLine = false) {
        if (lastLine || words.size() == 1)
            return leftJustification(words, maxWidth);
        return normalJustification(words, maxWidth);
        
    }
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> temp;
        vector<string> ans;
        int c = 0;
        for (auto word : words) {
            if ((c!=0) + c + word.size() <= maxWidth) {
                temp.push_back(word);
                c+=(c!=0);
                c+=word.size();
            } else {
                string ret = parseTheLine(temp, maxWidth);
                ans.push_back(ret);
                c = word.size();
                temp.clear();
                temp.push_back(word);
            }
            
        }
        if (c) {
            string ret = parseTheLine(temp, maxWidth, true);
            ans.push_back(ret);
        }
        return ans;
    }
};