#include <iostream>
#include <vector>

using namespace std;

/*
 * a[0] < a[1] > a[2]
 */
void wiggleSort(vector<int>& nums)
{
    // partition sort first, find the median element
    // for even, like 6 elements, use arr[3] as median
    // for odd, like 5 elements, use arr[2] as median
    int l = 0, r = nums.size() - 1;
    while (true) {
        int i = l;
        int left = i + 1;
        int right = r;
        while (left <= right) {
            while (left < nums.size() && nums[left] <= nums[i]) left++;
            while (right > i && nums[right] >= nums[i]) right--;
            if (left < right) swap(nums[left], nums[right]);
        }
        swap(nums[right], nums[i]);
        if (right == nums.size() / 2) break;
        else if (right < nums.size() / 2) l = right + 1;
        else r = right - 1;
    }
    int median = nums[nums.size() / 2];

    // move nums equal to median to the middle
    // for even numbers, that's fine
    // for odd number, make sure left part has more numbers
    int partition_idx = nums.size() / 2 - 1 + (nums.size() % 2);
    // [5, 4, 2] [6, 5]    => partition_idx = 2
    // [5, 4, 2] [6, 5, 5] => partition_idx = 2
    int target = 0;
    for (int i = target; i <= partition_idx; ++i) {
        if (nums[i] == median) {
            swap(nums[i], nums[target++]);
        }
    }
    target = nums.size() - 1;
    for (int i = target; i > partition_idx; --i) {
        if (nums[i] == median) {
            swap(nums[i], nums[target--]);
        }
    }

    // rearrage
    // M S S
    //  L L M
    vector<int> tmp(nums);

    int idx = 0;
    for (int i = 0; i < nums.size(); i = i + 2) {
        nums[i] = tmp[idx++];
    }
    idx = partition_idx + 1;
    for (int i = 1; i < nums.size(); i = i + 2) {
        nums[i] = tmp[idx++];
    }

}


int main()
{
    //vector<int> nums = {6, 5, 4, 5, 2};
    vector<int> nums = {1,1,2,1,2,2,1};
    wiggleSort(nums);
    for (int i = 0; i < nums.size(); ++i)
    {
        cout << nums[i] << " ";
    }
    cout << "\n";
}
