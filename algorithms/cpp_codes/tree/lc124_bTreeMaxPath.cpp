#include "treenode.h"

using namespace std;

class Solution {
public:
	int maxPathSum(TreeNode* root) {
        int maxPath = 0;
        std::cout << "aaaa\n";
        return maxPathSum(root, maxPath);
    }
    
    int maxPathSum(TreeNode* root, int& maxPath) {
        if (!root) return 0;
        std::cout << "root->val: " << root->val << "\n";
        int left = 0, right = 0;
        int max_left = 0, max_right = 0;
        if (root->left) {
            max_left = maxPathSum(root->left, left);
        }
        
        if (root->right) {
            max_right = maxPathSum(root->right, right);
        }
        std::cout << "left=" << left << ", right=" << right
                  << "max_left=" << max_left << ", max_right=" << max_right
                  << "\n";
        
        if (max_left < max_right) max_left = max_right;
        maxPath = (left > right ? left : right) + root->val;
        return (max_left > (left + right + root->val) ? max_left : (left + right + root->val));
    }



};

int main()
{
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode t3(3);
    t1.right = &t2;
    t2.left = &t3;
    Solution s;
    int v =s.maxPathSum(&t1);
    std::cout << v << "\n";
    return 0;
}
