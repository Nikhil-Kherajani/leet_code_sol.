class Solution {
    public List<Integer> luckyNumbers (int[][] matrix)
    {   
        List<Integer> res = new ArrayList<>();
        for(int i =0; i< matrix.length; i++)
        {
            
       
            
            int min = Integer.MAX_VALUE;
            int min_index = Integer.MAX_VALUE;
            for(int j = 0; j<matrix[i].length; j++)
            {

					
                if(matrix[i][j] < min)
                {
                    min = matrix[i][j];
                    min_index = j;     
                }
                
            }
            
       
            int flag = 0;
            for(int k = 0; k<matrix.length; k++)
            {
                if(matrix[k][min_index]> min)
                {
                    flag = 1;
                    break;
                }
            }
            if(flag==0)
                res.add(min);
        }
        return res;
    }
}