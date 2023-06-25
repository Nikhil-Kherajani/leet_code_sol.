class Solution {
    int[][] v ;
    int mod = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        v = new int[locations.length][fuel+1];
        // Arrays.fill(v , -1); 
        for (int[] row : v)
            Arrays.fill(row, -1);
       
        return ar(locations, finish, fuel , start);
    }
    
    public int ar(int[] locations, int finish, int fuel, int i) {
        
        int ans = 0;
        
        if(fuel < 0){ 
            return  ans;
        }
        if(v[i][fuel] != -1){
            return v[i][fuel];
        }
        else if(i == finish){
            ans += 1;
        }
        if(fuel > 0){
            for(int j = 0 ; j < locations.length ; j++){
                if(j != i)
                ans = ((ans%mod) + (ar(locations, finish , fuel - Math.abs(locations[j]-locations[i]), j)%mod)%mod);
            }
        }
        return v[i][fuel] = ans%mod;
        
    }
}