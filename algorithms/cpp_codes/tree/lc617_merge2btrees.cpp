#include "treenode.h"

class Solution {
public:
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        std::cout << t1 << " " << t2 << "\n";
		if (!t1 && !t2)
            return NULL;
        int val = 0;
        if (t1) {
            val += t1->val;
        }
        if (t2) {
            val += t2->val;
        }
        TreeNode* t = new TreeNode(val);
        std::cout << "t->val" << t->val << "\n";
        
        if (t1 && t2) {
            t->left = mergeTrees(t1->left, t2->left);
            t->right = mergeTrees(t1->right, t2->right);
            return t;
        }
        
        TreeNode* sTree;
        if (!t1) {
            sTree = t2;
        }
        if (!t2) {
            sTree = t1;
        }
        t->left = mergeTrees(sTree->left);
        t->right = mergeTrees(sTree->right);
        return t;
    }

	TreeNode* mergeTrees(TreeNode* t1) {
        if (!t1)
            return NULL;
        TreeNode* t = new TreeNode(t1->val);
        t->left = mergeTrees(t1->left);
        t->right = mergeTrees(t1->right);
        return t;
        
    }

};

int main()
{
    Solution s;
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode* t = s.mergeTrees(&t1, &t2);
    std::cout << t->val << "\n";
    return 0;
}
