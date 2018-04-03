#include <iostream>
#include <vector>

using namespace std;

vector<int> findDiagonalOrder(vector<vector<int> >& matrix) {
    vector<int> rst;
    if (matrix.empty()) return rst;
    int m = matrix.size();
    int n = matrix[0].size();
    if (n == 0) return rst;
    int step[][2] = {{-1, 1}, {1, -1}};
    int x = 0, y = 0;
    for (int i = 0; i < m * n; ++i) {
        cout << "x=" << x << ", y=" << y << "\n";
        rst.push_back(matrix[x][y]);
        int mode = (x + y) % 2;
        x = x + step[mode][0];
        y = y + step[mode][1];
        if ( x >= m ) { x = m - 1; y = y + 2; }
        if ( y >= n ) { x = x + 2; y = n - 1; }
        if ( x < 0 ) { x = 0; }
        if ( y < 0 ) { y = 0; }
    }
    return rst;
}

int main()
{
    vector<vector<int> > input;
    vector<int> a1; a1.push_back(1); a1.push_back(2); a1.push_back(3);
    vector<int> a2; a2.push_back(4); a2.push_back(5); a2.push_back(6);
    vector<int> a3; a3.push_back(7); a3.push_back(8); a3.push_back(9);
    input.push_back(a1);
    input.push_back(a2);
    input.push_back(a3);
    const vector<int>& rst = findDiagonalOrder(input);
    for (int i = 0; i < rst.size(); ++i)
    {
        std::cout << i << " ";
    }
    cout << "\n";
}
