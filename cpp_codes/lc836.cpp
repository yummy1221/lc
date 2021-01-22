#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> rec1 = {0, 0, 1, 1};
    vector<int> rec2 = {1, 1, 3, 3};
    int x1 = rec1[0], x2 = rec1[2];
    int x3 = rec2[0], x4 = rec2[2];
    bool overlapx = !((x2 <= x3) || (x4 <= x1));

    cout << "overlapx=" << overlapx << "\n";

    int y1 = rec1[1], y2 = rec1[3];
    int y3 = rec2[1], y4 = rec2[3];
    bool overlapy = !((y1 >= y4) || (y3 >= y2));
    cout << "overlapy=" << overlapy << "\n";
}
