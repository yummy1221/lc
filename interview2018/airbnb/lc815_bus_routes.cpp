#include <iostream>
#include <deque>
#include <vector>
#include <set>
#include <unordered_map>

using namespace std;

int numBusesToDestination(vector<vector<int>>& routes, int S, int T) {
    if (S == T) return 0;
    set<int> visited_bus;
    set<int> visited_stop;
    deque<int> busQ;
    unordered_map<int, vector<int>> busAtStop;      //stop->[buses]
    // initialize busAtStop
    for (int i = 0; i < routes.size(); ++i) {
        for (int j = 0; j < routes[i].size(); ++j) {
            busAtStop[routes[i][j]].push_back(i);
        }
    }
    for (int i = 0; i < busAtStop[S].size(); ++i) {
        busQ.push_back(busAtStop[S][i]);
    }

    int rst = 0;
    while (!busQ.empty()) {
        int level = busQ.size();
        rst++;
        for (int i = 0; i < level; i++) {
            int busNo = busQ.front();
            busQ.pop_front();
            for (int j = 0; j < routes[busNo].size(); ++j) {
                if (routes[busNo][j] == T) return rst;
                if (visited_stop.find(routes[busNo][j]) == visited_stop.end()) {
                    for (int k = 0; k < busAtStop[routes[busNo][j]].size(); ++k) {
                        if (visited_bus.find(busAtStop[routes[busNo][j]][k]) == visited_bus.end()) {
                            busQ.push_back(busAtStop[routes[busNo][j]][k]);
                            visited_bus.insert(busAtStop[routes[busNo][j]][k]);
                        }
                    }
                    visited_stop.insert(routes[busNo][j]);
                }
            }
        }
    }
    return -1;
}

int main()
{
    /*
    vector<vector<int>> routes = { {1, 2, 7}, {3, 6, 7}};
    cout << numBusesToDestination(routes, 1, 8) << "\n";
    */

    vector<vector<int>> routes = { {2}, {2, 8} };
    cout << numBusesToDestination(routes, 8, 2) << "\n";

}
