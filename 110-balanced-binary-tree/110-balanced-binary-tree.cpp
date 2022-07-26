class Solution {
public:
    int dfs(TreeNode* root, bool &flag) {
        if(flag == false) return 0;
        
        if(!root) return 0;
        
        int lh = dfs(root->left, flag);
        int rh = dfs(root->right, flag);
        
        if(abs(lh-rh) > 1) flag = false;
        
        return 1+max(lh, rh);
    }
    bool isBalanced(TreeNode* root) {
        bool flag = true;
        dfs(root, flag);
        return flag;
    }
};