class Solution {
public:
vector<vector<string>> ans;
bool safe(int r, int c, vector<string>&board, int n)
{
    int row=r, col=c;
    while(row>=0 && col>=0)
        if(board[row--][col--]=='Q')    return false;
    row=r, col=c;
    while(row>=0)
        if(board[row--][col]=='Q')    return false;
    row=r, col=c;
    while(row>=0 && col<n)
        if(board[row--][col++]=='Q')    return false;
    return true;
}
void placeQ(int row, vector<string>&board, int n)
{
    if(row==n)
    {
        ans.push_back(board);
        return;
    }
    for(int col=0;col<n;col++)
    {
        if(safe(row,col,board,n))
        {
            board[row][col] = 'Q';
            placeQ(row+1,board,n);
            board[row][col] = '.';
        }
    }
}
vector<vector<string>> solveNQueens(int n) {
    string s="";
    for(int i=0;i<n;i++)
        s += ".";
    vector<string> board(n,s);
    placeQ(0,board,n);
    return ans;
}
};