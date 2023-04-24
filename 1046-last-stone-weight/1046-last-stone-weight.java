class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)return stones[0];
        Arrays.sort(stones);
        int y = stones.length-1;
        int x = stones.length-2;
        while(x>=0){
            if(stones[x]==stones[y]){
                stones[x] = 0;
                stones[y] = 0;
            }else{
                stones[y] -= stones[x];
                stones[x] = 0;
            }
            Arrays.sort(stones);
            if(stones[x]==0)break;
        }
        return stones[y];
    }
}