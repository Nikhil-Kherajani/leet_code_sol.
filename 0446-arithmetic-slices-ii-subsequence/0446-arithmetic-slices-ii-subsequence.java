class Solution {
    HashMap<Pair<Integer, Long>, Integer> memo = new HashMap<>();
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                total += dfs(j+1, j, (long)A[j]-A[i], A);
            }
        }
        return total;
    }
    
    int dfs(int index, int last, long diff, int[] A){
        if(index == A.length)
            return 0;
        
        Pair<Integer, Long> hash = new Pair(last, diff);
        if(memo.get(hash) != null)
            return memo.get(hash);
        
        int local = 0;
        for(int next = index; next < A.length; next++){
            if((long)A[next]-A[last] == diff){
                local += dfs(next+1, next, diff, A) + 1;
            }
        }
        memo.put(hash, local);
        return local;
    }
}