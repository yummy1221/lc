#include <iostream>
#include <vector>

using namespace std;

/*
 * a[0] <= a[1] >= a[2]
 * only need to compare with the one after it
 * O(N) time complexity
 */
void wiggleSort(vector<int>& nums)
{
    if (nums.empty()) return;   // nums.size() is unsigned, size - 1 will be a big number if size = 0
    for (int i = 0; i < nums.size() - 1; ++i) {
        if ((i % 2 == 0 && nums[i] > nums[i+1])             // for even index, must be small
                || (i % 2 == 1 && nums[i] < nums[i+1])) {   // for odd index, must be big
            swap(nums[i], nums[i+1]);
        }
    }
}


int main()
{
    vector<int> nums = {3, 1, 2, 4};
    wiggleSort(nums);
    for (int i = 0; i < nums.size(); ++i)
    {
        cout << nums[i] << " ";
    }
    cout << "\n";
}
