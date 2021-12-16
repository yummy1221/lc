#include "treenode.h"

#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
    std::vector<int> inorderTraversal(TreeNode* root)
    {
        vector<int> rst;
        stack<TreeNode*> q;
        if (root)
        {
            q.push(root);
        }
        
        while (!q.empty())
        {
            while(q.top()->left)
            {
                q.push(q.top()->left);
            }
            
            while (!q.empty())
            {
                TreeNode* tmp = q.top();
                q.pop();
                rst.push_back(tmp->val);
                if (tmp->right) {
                    q.push(tmp->right);
                    break;
                }
            }
        }
        return rst;
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
    vector<int> v =s.inorderTraversal(t1);
    for (int i = 0; i < v.size(); ++i)
    {
        std::cout << v[i] << "\n";
    }
    return 0;
}
