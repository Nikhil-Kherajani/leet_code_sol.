class Solution {
static boolean check(int x, int y,int x1, int y1, int r){
    return (x-x1)*(x-x1) + (y-y1)*(y-y1) - r*r <=0; 
}
public int[] countPoints(int[][] points, int[][] queries) {
    int[] ans = new int[queries.length];
    for(int i = 0;i<queries.length;i++){
        for(int j = 0;j<points.length;j++){
           if(check(points[j][0],points[j][1], queries[i][0],queries[i][1],queries[i][2])){
               ans[i]++;
           }
      }
    }
    return ans;
}
}