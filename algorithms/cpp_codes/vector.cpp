#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> a = {2, 3, 4, 6};
    vector<int> b = {2, 4, 3, 6};

    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    cout << (a == b) << "\n";

}
