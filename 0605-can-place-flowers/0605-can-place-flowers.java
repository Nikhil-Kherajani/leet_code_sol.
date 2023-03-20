class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 1, ans = 0;
        final int len = flowerbed.length;
        while(i < len){
            if(flowerbed[i] == 0 ){
                count++;
                i++;
            }
            else if(flowerbed[i] == 1){
                count = 0;
                i++;
            }
            if(count == 3){
                ans++;
                count = 1;
            }
        }
        if(count == 2){
            ans++;
        }
        if(ans >= n){
            return true;
        }
        
            return false;
        
    }
}