#include <iostream>
#include <vector>

using namespace std;

int longestMountain(vector<int>& A) {
    int rst = 0;
    bool inMountain = false;
    bool rising = false;
    int start = -1;
    for (int i = 1; i < A.size(); ++i) {
        if (inMountain) {
            if (rising) {
                if  (A[i] > A[i-1]) continue;
                else if (A[i] == A[i-1]) {
                    inMountain = false;
                } else {
                    rising = false;
                }
            } else {
                if (A[i] < A[i-1]) continue;
                else {
                    inMountain = false;
                    cout << "i=" << i << ", start=" << start << "\n";
                    rst = rst > i - start ? rst : i - start;
                }
            }
        } 
        if (!inMountain) {
            if (A[i] > A[i-1]) {
                inMountain = true;
                rising = true;
                start = i-1;
            }
        }
    }
    if (inMountain && !rising) rst = rst > A.size() - start ? rst : A.size() - start;

    return rst;
}

int main()
{
    vector<int> arr = { 875,884,239,731,723,685 };
    cout << longestMountain(arr) << "\n";
}
