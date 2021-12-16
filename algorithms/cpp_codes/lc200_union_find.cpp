#include <iostream>
#include <map>
#include <vector>

// union find

using namespace std;

int numIslands(vector<vector<char>>& grid) {
    map<int, int> connected;
    int count = 0;
    for (int i = 0; i < grid.size(); ++i)
    {
        for (int j = 0; j < grid[i].size(); ++j)
        {
            if (grid[i][j] == 0) continue;
            int left = 0, up = 0;
            if (i > 0) up = grid[i-1][j];
            if (j > 0) { left = grid[i][j-1]; cout << left << " " << grid[i][j-1] << "\n";
                       cout << "i=" << i << ", j=" << j << ", " << grid[i][j] << "\n";}
            cout << "i=" << i << ", j=" << j
                << ", left=" << left << ", up=" << up << "\n";
            if (left == 0 && up == 0)
            {
                cout << "i=" << i << ", j=" << j << "\n";
                grid[i][j] == ++count;
                cout << "count=" << count << "\n";
                connected[count] = count;
            }
            else if (left && up)
            {
                if (left == up) grid[i][j] = left;
                else
                {
                    int min = left > up ? up : left;
                    int max = left > up ? left : up;
                    grid[i][j] = min;
                    connected[max] = min;
                }
            }
            else
            {
                grid[i][j] = left + up;
            }
        }
    }
    cout << connected.size() << "\n";
    for (map<int,int>::iterator it = connected.begin(); it != connected.end(); ++it)
    {
        if (it->first != it->second) count--;
    }
    cout << grid[0][0] << "\n";
    return count;
}


int main()
{
    vector<vector<char>> grid;
    char tmpa[] = {'1','1','0','0','0'};
    vector<char> a(tmpa, tmpa+5);
    char a1 = 49;
    cout << a1 << "\n";
}
