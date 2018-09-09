#include <set>
#include <iostream>

using namespace std;

int main()
{
    set<double> a;
    a.insert(10.0);
    cout << a.size() << "\n";
    a.erase(10.0);
    cout << a.size() << "\n";
}
