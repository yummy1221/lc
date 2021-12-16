#include <iostream>
#include <map>

using namespace std;

int main()
{
    map<int, int> a;
    a[10] = 11;
    a[2] = 3;
    cout << a[4] << "\n";
}
