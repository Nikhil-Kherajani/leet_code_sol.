class Solution {
public:
      
   	// this function converst the answer into strings each row into a string
    vector<string> constructAnswer(vector<vector < char>> &board, int n)
    {

        vector<string> vec;

        for (int i = 0; i < n; i++)
        {
            string tempString = "";
            for (int j = 0; j < n; j++)
                tempString += board[i][j];

            vec.push_back(tempString);
        }

        return vec;
    }
    
//     function to check validity of cell
    bool isValid(vector< vector< char>> &board, int currentRow,int currentCol, int n)
    {
        return (isRowValid(board, currentRow, n) && isColValid(board, currentCol, n) && isDiagonalValid(board, currentRow, currentCol, n)); 
        
     }
    
    
//     function to check Row Validity
    bool isRowValid(vector< vector< char>> &board, int currentRow, int n)
    {
        for(int currentCol=0;currentCol<n;currentCol++)
        {
            if(board[currentRow][currentCol]=='Q')
                return false;
        }
        
        
        return true;
    }

    //     function to check Col Validity
    bool isColValid(vector< vector< char>> &board, int currentCol, int n)
    {
        for(int currentRow=0;currentRow<n;currentRow++)
        {
            if(board[currentRow][currentCol]=='Q')
                return false;
        }
        
        
        return true;
    }

    //     function to check Diagonal Validity
    bool isDiagonalValid(vector< vector< char>> &board, int currentRow,int currentCol, int n)
    {
        
        int i = currentRow;
        int j = currentCol;
        while(i>=0 && j>=0) // first diag
        {
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
         i = currentRow;
         j = currentCol;
        while(i>=0 && j<n) // second diag
        {
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
         i = currentRow;
         j = currentCol;
        while(i<n && j>=0) // third diag
        {
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
         i = currentRow;
         j = currentCol;
        while(i<n && j<n) // fourth diag
        {
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }
        return true;
        
        
    }

    

   	//     main Function
    void nQueens(vector<vector < string>> &answer, vector< vector< char>> &board, int currentRow, int n)
    {
        if (currentRow == n)
        {
           	//             The function we return a list of stringa nd push it inside the answer
            vector<string>tempans =constructAnswer(board, n);
            answer.push_back(tempans);
            return;
        }

        for (int currentCol = 0; currentCol < n; currentCol++)
        {
           	//             If the cell is valid then we place the queen 
            if (isValid(board, currentRow, currentCol, n))
            {
                board[currentRow][currentCol] = 'Q';
               	//                 we move to the next row after we finish putting our queen into the given row
                nQueens(answer, board, currentRow + 1, n);
               	//                 After we come out of the function we undo the change
                board[currentRow][currentCol] = '.';
            }
        }

        return;
    }
    
    int totalNQueens(int n) {
        
        vector<vector < string>> answer;
            vector<vector < char>> board(n, vector<char> (n, '.'));

            nQueens(answer, board, 0, n);

            return answer.size();
        
    }
    
    
    
};