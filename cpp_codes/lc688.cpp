#include <iostream>
#include <unordered_map>
#include <map>

using namespace std;

const int NUM_DIRECTIOINS = 8;
int MOVE[8][2] = {
    {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
};

map<int, map<pair<int, int>, double> > mem;

double knightProbability(int N, int K, int r, int c) {
    cout << "K=" << K << ", r=" << r << ", c=" << c << "\n";
    if (r >= N || r < 0 || c >= N || c < 0) return 0.0;
    if (K == 0) return 1.0;

    if (mem.find(K) != mem.end() && mem[K].find(make_pair(r, c)) != mem[K].end())
        return mem[K][make_pair(r, c)];

    int r_new = r, c_new = c;
    double rst = 0.0;
    for (int i = 0; i < NUM_DIRECTIOINS; i++) {
        r_new = r + MOVE[i][0];
        c_new = c + MOVE[i][1];
        rst += (knightProbability(N, K-1, r_new, c_new) / double(NUM_DIRECTIOINS));
    }

    mem[K][pair<int, int>(r, c)] = rst;
    return rst;
}

int main()
{
    cout << knightProbability(8, 30, 6, 4) << "\n";
}
