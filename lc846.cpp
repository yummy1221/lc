#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

bool isNStraightHand(vector<int>& hand, int W) {
    if (hand.size() % W != 0) return false;
    sort(hand.begin(), hand.end());
    map<int, int> num_first_pos;
    for (int i = hand.size() - 1; i >= 0; --i) {
        num_first_pos[hand[i]] = i;
    }
    bool visited[hand.size()];
    for (int i = 0; i < hand.size(); ++i) visited[i] = false;
    for (int i = 0; i < hand.size(); ++i) {
        if (visited[i]) continue;
        for (int j = 1; j < W; ++j) {
            if (num_first_pos.find(hand[i]+j) == num_first_pos.end()) return false;
            int pos = num_first_pos[hand[i]+j];
            visited[pos] = true;
            if (pos == hand.size()-1 || hand[pos+1] != hand[i]+j)
                num_first_pos.erase(hand[i]+j);
            else
                num_first_pos[hand[i]+j] = pos + 1;
        }
    }
    return true;
}

int main()
{
    vector<int> arr = {1,2,3,6,2,3,1,7,8};
    cout << isNStraightHand(arr, 3) << "\n";
}

