#include <iostream>
#include <vector>

using namespace std;

// move left pointer
void shiftLeft(const vector<int>& heights, int& left)
{
    int current = heights[left];
    int idx = left;
    while (idx >= 0 && heights[idx] <= current) {
        if (heights[idx] < current) {
            left = idx;
            current = heights[left];
        }
        idx--;
    }
}

// move right pointer
void shiftRight(const vector<int>& heights, int& right)
{
    int current = heights[right];
    int idx = right;
    while (idx < heights.size() && heights[idx] <= current) {
        if (heights[idx] < current) {
            right = idx;
            current = heights[right];
        }
        idx++;
    }
}

vector<int> pourWater(vector<int>& heights, int V, int K)
{
    int left = K;
    int right = K;
    shiftLeft(heights, left);
    shiftRight(heights, right);
    for (int i = 0; i < V; i++) {
        if (left < K) {
            heights[left]++;
            left = K;
            shiftLeft(heights, left);
        } else if (right > K) {
            heights[right]++;
            right = K;
            shiftRight(heights, right);
        } else {
            heights[left]++;
            left = K;
            right = K;
            shiftLeft(heights, left);
            shiftRight(heights, right);
        }
    }
    return heights;
}

int main()
{
    //vector<int> heights = { 2, 1, 1, 2, 1, 2, 2 };
    //pourWater(heights, 4, 3);

    /*
    vector<int> heights = { 1, 2, 3, 4 };
    pourWater(heights, 2, 2);
    */

    /*
    vector<int> heights = { 3, 1, 3 };
    pourWater(heights, 5, 1);
    */

    vector<int> heights = { 1,2,3,4,3,2,1,2,3,4,3,2,1};
    pourWater(heights, 10, 2);

    for (int i = 0; i < heights.size(); ++i) {
        cout << heights[i] << " ";
    }
    cout << "\n";
}
