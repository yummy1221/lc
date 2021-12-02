#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int findMissingPositive0(vector<int>& nums) { // O(n) time, O(n) space
    unordered_set<int> num_set;
    int max_num = 0;
    for (int i = 0; i < nums.size(); ++i) {
        max_num = max(nums[i], max_num);
        num_set.insert(nums[i]);
    }

    for (int i = 1; i < max_num; ++i) {
        if (num_set.find(i) == num_set.end()) return i;
    }

    return max_num + 1;
}

int findMissingPositive(vector<int>& nums) { // O(n) time, O(1) space
    int i = 0;
    // the smallest positive number must be in range 1 ~ n, n = nums.size()
    // put the positive numbers into the position same with its index
    // e.g. num[0] = 1, num[1] = 2, num[2] = 3 ...
    // when we encounter a number that is not equal to its index + 1, that is the one missing
    while (i < nums.size()) {
        if (nums[i] != i + 1    // put the numbers into correct position
                && nums[i] > 0 && nums[i] <= nums.size()    // only care about number in range 1 ~ n
                && nums[i] != nums[nums[i]-1]) {            // make sure we don't swap indefinitely
            swap(nums[i], nums[nums[i]-1]);
        } else {
            i++;
        }
    }
    
    // now after rearranging numbers, it is time to find which one is missing
    for (i = 0; i < nums.size(); ++i) {
        if (nums[i] != i + 1) return i + 1;
    }
    // [1, 2, 3, 4]
    return nums.size() + 1;
}

int main()
{
    vector<int> nums0 = {1, 2, 0};
    vector<int> nums1 = {3, 4, -1, 1};
    vector<int> nums2 = {7, 8, 9, 11, 12};
    cout << findMissingPositive(nums0) << "\n";
    cout << findMissingPositive(nums1) << "\n";
    cout << findMissingPositive(nums2) << "\n";
}
