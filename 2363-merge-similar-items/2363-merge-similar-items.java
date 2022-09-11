class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0;i<items1.length;i++){
            hm.put(items1[i][0],items1[i][1]);
        }
        for(int i = 0;i<items2.length;i++){
            if(hm.containsKey(items2[i][0])){
                hm.put(items2[i][0],hm.get(items2[i][0])+items2[i][1]);
            }
            else{
                hm.put(items2[i][0],items2[i][1]);
            }
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            List<Integer> ans = new ArrayList<>();
            int key = entry.getKey();
            int value = entry.getValue();
            ans.add(key);
            ans.add(value);
            al.add(ans);
        }
        return al;
    }
}