
class Solution {
public:
    void solve(TreeNode * node  , string &str ) {
      if(node == NULL ){
          str.push_back(48 ) ;
       return ;
       }
        
        str.push_back(node->val + 48 ) ;
        solve(node->left , str ) ;
        solve(node->right , str ) ;
        return ;
    }
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p== NULL && q != p ) return false ;
        if(q== NULL && q != p ) return false ;
        if(p == NULL && p == q ) return true ;
        
        string str1 ;
        string str2 ;
    
             solve(p ,str1 ) ;
             solve(q , str2) ;
   //     cout<<str1 <<" " <<str2 <<endl ;
        if(str1 ==  str2 ) return true ; 
        else return false ;
    }
};