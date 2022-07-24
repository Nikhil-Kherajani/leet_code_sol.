class Solution {
public:
    
    void inorder(TreeNode* r,vector<int>&a){
        if(r==NULL){
            return ;
        }
        inorder(r->left,a);
        a.push_back(r->val);
        inorder(r->right,a);
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int>a;
        
        inorder(root , a);
        
        return a;
    }
};