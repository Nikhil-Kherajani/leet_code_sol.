class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] num = new boolean[n];
    
        for(List<Integer> val : edges){
            num[val.get(1)] = true;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!num[i])
            ans.add(i);
        }
        return ans;
        
    }
}