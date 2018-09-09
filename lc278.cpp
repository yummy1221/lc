#include <iostream>

using namespace std;


// 2126753390 versions
// 1702766719 is the first bad version.
bool isBadVersion(int version)
{
    if (version < 1702766719) return false;
    return true;
}

int firstBadVersion(int n) {
    long s = 1, e = n;
    long mid = 0;
    int firstBad = n;
    int count = 0;
    while (s <= e) {
        mid = (s + e) / 2;

        cout << "s=" << s << ", e=" << e;
        cout << ", mid=" << mid << ", isBadVersion=" << isBadVersion(mid) << "\n";
        if (isBadVersion(mid)) {
            firstBad = mid;
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    cout << "firstBad=" << firstBad << "\n";
    return firstBad;
}

int main()
{
    firstBadVersion(2126753390);
}
