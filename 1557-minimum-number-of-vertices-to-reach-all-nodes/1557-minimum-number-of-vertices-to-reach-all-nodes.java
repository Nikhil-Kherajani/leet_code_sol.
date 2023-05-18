class Solution {
     public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList();
        
        boolean[] inDegree = new boolean[n];
        
        for (List<Integer> edge : edges) {
			//get 'to' node from the edge and set the in-degree flag for it 
            inDegree[edge.get(1)] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!inDegree[i])
                res.add(i);
        }
        
        return res;
    }
}