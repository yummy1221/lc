#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root) {
            return NULL;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode* left = NULL;
        TreeNode* right = NULL;
        if (root->left) {
            left = lowestCommonAncestor(root->left, p, q);
        }
        if (root->right) {
            right = lowestCommonAncestor(root->right, p, q);
        }
        if (left && right) {
            return root;
        }
        if (right) {
            return right;
        }
        if (left) {
            return left;
        }
        return NULL;
    }
};

int main()
{
    TreeNode root(2);
    TreeNode left(1);
    TreeNode right(3);
    root.left = &left;
    root.right = &right;

    Solution s;
    TreeNode* rst = s.lowestCommonAncestor(&root, &left, &right);

    std::cout << rst->val << "\n";
    
}
