#include <vector>
#include <iostream>

int main()
{
    using namespace std;
    vector<int> a = {3, 2, 5, 7, 2};
    sort(a.begin() + 3, a.end());
    for (vector<int>::iterator it = a.begin(); it != a.end(); ++it)
        cout << *it << " ";
    cout << "\n";
}
