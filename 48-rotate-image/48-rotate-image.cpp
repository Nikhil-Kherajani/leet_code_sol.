class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n=matrix.size();
        for(int i=0 ; i<n ; i++)                                //Transpose of Original Matrix
            for(int j=0 ; j<i ; j++)
                swap(matrix[i][j],matrix[j][i]);
        
        for(int i=0 ; i<n ; i++)                                        // Reverse all the rows
            reverse(matrix[i].begin(),matrix[i].end());
    }
};