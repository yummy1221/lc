#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    long ip_long = 100;
    ip_long += (int)pow(2, 0);
    long ip2 = 100;
    ip2 += (2 << (0));
    cout << ip_long << "\n";
    cout << ip2 << "\n";
}
