class Solution {
    public static class Pair{
        int r;
        int c;
        int s;
        Pair(int r,int c, int s){
           this.r=r;
           this.c=c;
           this.s=s;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int visited[][]=new int[m][n];
        int dist[][]=new int[m][n];
        Queue<Pair> q=new LinkedList<Pair>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                    // System.out.println(i+"\t"+j+"\t");
                }else{
                    visited[i][j]=0;
                }
                
            }
        }
        // System.out.println(q);
        int rows[]={-1,0,+1,0};
        int cols[]={0,+1,0,-1};
      while(!q.isEmpty()){
        //   Pair rem=
          int row=q.peek().r;
          int col=q.peek().c;
          

          int step=q.peek().s;
          q.remove();
        //   System.out.println(row+"\t"+col+"\t"+step);
          dist[row][col]=step;
          for(int i=0;i<4;i++){
              int nrow=row+rows[i];
              int ncol=col+cols[i];
              if(nrow<m&&nrow>=0&&ncol>=0&&ncol<n&&visited[nrow][ncol]==0){
                 visited[nrow][ncol]=1;
                 q.add(new Pair(nrow,ncol,step+1)); 
              }
          }

      }
    // while(!q.isEmpty()){
    //          int row=q.peek().r;
    //       int col=q.peek().c;
          

    //        int step=q.peek().s;
    //        q.remove();
    //     System.out.println(row+"\t"+col+"\t"+step);

    // }
        return dist;
    }
}