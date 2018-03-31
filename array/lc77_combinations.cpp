#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > rst;
        vector<int> comb;
        for (int i = 1; i <= k; ++i) {
            comb.push_back(i);
        }
        combine(rst, comb, 0, 1, n, k);
        return rst;
    }
    void combine(vector<vector<int> >& rst, vector<int>& pre, int index, int s, int e, int k) {
        std::cout << "in combine index=" << index
                  << ", s=" << s << ", e=" << e << ", k=" << k << "\n";
        if (k == 0) {
            rst.push_back(pre);
            return;
        }
        if (s > e) return;
        
        pre[index] = s;
        combine(rst, pre, index+1, s+1, e, k-1); // put i in vector
        combine(rst, pre, index, s+1, e, k);
        
    }
};

int main()
{
    Solution s;
    vector<vector<int> > rst = s.combine(4, 2);
    for (int i = 0; i < rst.size(); ++i)
    {
        for (int j = 0; j < rst[i].size(); ++j)
        {
            std::cout << rst[i][j] << " ";
        }
        std::cout << "\n";
    }
}
