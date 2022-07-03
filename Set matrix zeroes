class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector<vector<int>> temp = matrix;
        for(int i = 0; i<matrix.size();i++){
            for(int j = 0;j<matrix[0].size();j++){
                if(temp[i][j] == 0){
                    for(int row = 0;row<matrix[0].size();row++){
                        matrix[i][row] = 0;
                    }
                    for(int col = 0;col<matrix.size();col++){
                        matrix[col][j] = 0;
                    }
                }
            }
        }
    }
};
