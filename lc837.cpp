#include <iostream>
#include <map>

using namespace std;

int abc = 0;

double new21Game(int N, int K, int W, map<pair<int, int>, double>& prob) {
    cout << "N=" << N << ", K=" << K << "\n";
    cout << "abc=" << ++abc << "\n";

    double rst = 0.0;
    double probability = 0.0;
    if (K < 1) return 1.0;
    for (int i = 1; i <= W; ++i) {
        if (i >= K) {
            if (i <= N) probability = 1.0;
            else probability = 0.0;
        }
        else {
            if (prob.find(make_pair(N-i, K-i)) != prob.end())
                probability = prob[make_pair(N-i, K-i)];
            else
                probability = new21Game(N - i, K - i, W, prob);
        }
        rst += probability / (double)W;
    }
    prob[make_pair(N, K)] = rst;
    return rst;
}

int main()
{
    map<pair<int, int>, double> prob;
    //int N=421, K=400, W=47;
    int N = 9811, K = 8776, W = 1096;
    cout << "rst=" << new21Game(N, K, W, prob) << "\n";
    cout << "prob.size() = " << prob.size() << "\n";
};
