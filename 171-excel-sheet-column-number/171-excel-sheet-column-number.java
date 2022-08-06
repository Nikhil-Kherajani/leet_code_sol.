class Solution {
public int titleToNumber(String columnTitle) {

    int res = 0;
    for(char c: columnTitle.toCharArray()){
        int n = c -'A' + 1;
        res = res*26 + n;
    }
    
    return res;
}
}