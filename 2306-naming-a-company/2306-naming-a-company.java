

class Solution {
    public long distinctNames(String[] ideas) {
    long res = 0, cnt[][] = new long[26][26];
    Set<String>[] s = new HashSet[26];
    for (int i = 0; i < 26; ++i)
        s[i] = new HashSet<>();    
    for (var idea : ideas)
        s[idea.charAt(0) - 'a'].add(idea.substring(1));
    for (int i = 0; i < 26; ++i)
        for (var suff : s[i])
            for (int j = 0; j < 26; ++j)
                cnt[i][j] += s[j].contains(suff) ? 0 : 1;
    for (int i = 0; i < 26; ++i)
        for (int j = 0; j < 26; ++j)
            res += cnt[i][j] * cnt[j][i];
    return res;
}
}