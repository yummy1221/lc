#include <iostream>
#include <vector>
#include <map>
#include <set>

using namespace std;

int main()
{
    vector<pair<int, int>> points;
    /*
    points.push_back(make_pair(1, 1));
    points.push_back(make_pair(-1, 1));
    points.push_back(make_pair(-1, -1));
    points.push_back(make_pair(1, -1));
    */
    points.push_back(make_pair(0, 0));
    points.push_back(make_pair(1, 0));
    double x_mid = ((double)points[0].first + (double)points[1].first) / 2.0;
    cout << "x_mid=" << x_mid << "\n";

    map<int, set<int>> y_to_xsets;

    for (vector<pair<int, int>>::iterator it = points.begin();
            it != points.end(); ++it) {
        cout << "processing pair: x=" << it->first << " y=" << it->second << "\n";

        double reflext_x = (int)(x_mid * 2) - it->first;
        cout << "reflext_x=" << reflext_x << "\n";

        if (y_to_xsets[it->second].find(reflext_x) == y_to_xsets[it->second].end()) {
            y_to_xsets[it->second].insert(it->first);
        } else {
            y_to_xsets[it->second].erase(reflext_x);
        }
    }

    cout << "start printing map size=" << y_to_xsets.size() << "\n";
    cout << y_to_xsets[0].size() << "\n";
    for (map<int, set<int>>::iterator it = y_to_xsets.begin(); 
            it != y_to_xsets.end(); ++it)
    {
        cout << "hhhhh\n";
        cout << it->first << ": ";
        for (set<int>::iterator its = it->second.begin(); its != it->second.end(); ++its)
            cout << *its << " ";
        cout << "\n";
    }
}

