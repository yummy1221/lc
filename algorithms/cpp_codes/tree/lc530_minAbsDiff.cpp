#include "treenode.h"

#include <limits.h>

using namespace std;

class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        if (!root) return INT_MAX;
        int max = 0, min = 0;
        return getRange(root, max, min);
    }
    
    int getRange(TreeNode* root, int& max, int& min) {
        int rst = INT_MAX;
        if (!root->left && !root->right) {
            max = min = root->val;
            return INT_MAX;
        }
        min = root->val;
        max = root->val;
        
        int left = INT_MAX, right = INT_MAX;
        if (root->left) {
            int tmp_max;
            left = getRange(root->left, tmp_max, min);
            rst = (rst < (root->val - tmp_max)) ? rst : (root->val - tmp_max);
        }
        if (root->right) {
            int tmp_min;
            right = getRange(root->right, max, tmp_min);
            rst = (rst < (tmp_min - root->val)) ? rst : (tmp_min - root->val); 
        }
        std::cout << "root->val=" << root->val
                  << ", rst=" << rst
                  << ", max=" << max
                  << ", min=" << min << "\n";
        return rst;
    }
};

int main()
{
    TreeNode t1(543);
    TreeNode t2(384);
    TreeNode t3(445);
    TreeNode t4(652);
    TreeNode t5(699);
    t1.left = &t2;
    t2.right = &t3;
    t1.right = &t4;
    t4.right = &t5;
    Solution s;
    int v = s.getMinimumDifference(&t1);
    std::cout << v << "\n";
    return 0;
}
