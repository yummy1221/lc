#include <iostream>
#include <vector>
#include <map>

using namespace std;

int findMaxLength2(vector<int>& nums) {
    if (nums.empty()) return 0;
    int len = nums.size();
    int ones[nums.size()];
    ones[0] = nums[0];
    for (int i = 1; i < len; ++i) {
        ones[i] = ones[i-1] + nums[i];
    }

    int numOfOnes;
    int maxLength = 0;
    int length = 0;
    int j = 0;
    for (int i = 0; i < len; i++) {
        if (maxLength <= 1)
            j = i + 1;
        else
            j = maxLength + i - 1;
        for (; j < len; j=j+2) {
            numOfOnes = ones[j] - ones[i] + nums[i];
            if ((j-i+1)/2 == numOfOnes) length = j - i + 1;
        }
        maxLength = (maxLength > length) ? maxLength : length;
    }
    return maxLength;
}

int findMaxLength(vector<int>& nums)
{
    int sum = 0;
    int max = 0;
    map<int, int> sumIndexMap;
    sumIndexMap[0] = -1;
    for (int i = 0; i < nums.size(); ++i)
    {
        sum += (nums[i] == 0 ? -1 : 1);
        if (sumIndexMap.find(sum) != sumIndexMap.end())
        {
            max = max > (i - sumIndexMap[sum]) ? max : (i - sumIndexMap[sum]); 
        }
        else
        {
            sumIndexMap[sum] = i;
        }
    }
    return max;
}

int main()
{
    vector<int> a;
    std::cout << "findMaxLength=" << findMaxLength(a) << "\n";
    a.push_back(1);
    std::cout << "findMaxLength=" << findMaxLength(a) << "\n";
    a.push_back(0);
    a.push_back(0);
    a.push_back(0);
    std::cout << "findMaxLength=" << findMaxLength(a) << "\n";
    a.push_back(0);
    a.push_back(1);
    std::cout << "findMaxLength=" << findMaxLength(a) << "\n";
    a.push_back(1);
    a.push_back(0);
    std::cout << "findMaxLength=" << findMaxLength(a) << "\n";
}
