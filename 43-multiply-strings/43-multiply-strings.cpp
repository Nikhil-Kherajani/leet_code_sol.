class Solution {
public:    
    string multiply(string num1, string num2) {
        std::string res = "";

        auto len1 = num1.length();
        auto len2 = num2.length();

        for (size_t i = 0; i < len1 + len2; i ++ )
        {
            res.append("0");    
        }

        auto pos = 0;
        while (pos < len1 + len2 - 1) {
            for (size_t i1 = 0; i1 < len1; i1++ ) {
                int i2 = pos - i1;
                if ( i2 < 0 ) {
                    break;
                }
                if ( i2 >= len2 ) {
                    continue;
                }
                else {
                    int current = int(res[len1 + len2 - 1 - pos] - '0') + int(num1[len1 - 1 - i1] - '0') * int(num2[len2 - 1 - i2] - '0');
                    res[len1 + len2 - 1 - pos] = char('0' + current % 10);
                    auto rest = (int(res[len1 + len2 - 1 - pos - 1] - '0') + current / 10) / 10;
                    res[len1 + len2 - 1 - pos - 1] = char('0' + (int(res[len1 + len2 - 1 - pos - 1] - '0') + current / 10) % 10);
                    if (rest > 0 ) {
                        for (size_t i = pos + 2; i < len1 + len2; i ++ ) {
                            current = int(res[len1 + len2 - 1 - i] - '0') + rest;
                            res[len1 + len2 - 1 - i] = char('0' + current % 10);
                            rest = current / 10;
                            if ( rest == 0 ) {
                                break;
                            }
                        }
                    }
                }                    
            }
            pos ++; 
        }
        int start_position = len1 + len2 - 1;
        for (size_t i = 0; i < len1 + len2 - 1; i ++ ) {
            if (res[i] != '0') {
                start_position = i;
                break;
            }
        }
        res = res.substr(start_position);

        return res;
    }
};