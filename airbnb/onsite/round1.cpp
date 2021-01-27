#include <iostream>
#include <vector>
#include <map>
#include <unordered_set>

using namespace std;

bool acceptStates(
        const map<pair<char, char>, vector<char>>& transitionMetric,
        const unordered_set<char>& acceptStat,
        vector<char>& inputStat) {
    cout << "inputStat=";
    for (auto x : inputStat) cout << x << " ";
    cout << "\n";
    if (inputStat.size() == 1) {
        if (acceptStat.find(inputStat[0]) != acceptStat.end()) return true;
        return false;
    }
    vector<vector<char>> nextLevel;
    for (int i = 0; i < inputStat.size() - 1; i++) {
        nextLevel.push_back( transitionMetric.at(make_pair(inputStat[i], inputStat[i+1])) );
    }
    // generate next Level of input
    vector<int> indices(nextLevel.size(), 0);
    cout << "nextLevels:\n";
    for (auto x : nextLevel) {
        cout << "\t";
        for (auto y : x) {
            cout << y << " ";
        }
        cout << "\n";
    }
    int idx = nextLevel.size() - 1;
    vector<char> next;
    while (idx >= 0) {
        for (int i = 0; i < nextLevel.size(); ++i) {
            next.push_back(nextLevel[i][indices[i]]);
        }
        for (auto x : next) cout << x << " ";
        cout << " - next \n";
        if (acceptStates(transitionMetric, acceptStat, next)) return true;
        int pre_idx = idx;
        while (idx >= 0 && (indices[idx] == nextLevel[idx].size() - 1)) idx--;
        if (idx < 0) break;
        if (idx != pre_idx) {
            for (int i = idx + 1; i < indices.size(); ++i) indices[i] = 0;
        }
        indices[idx]++;
        for (auto x : indices) cout << x << " ";
        cout << " indices\n";
        next.clear();
    }
    return false;
}

/*
 * Question:
 * a b c
 * (ab)(bc) => b c/a
 * b c | b a
 * (bc) | (ba)
 * c/a | a/b
 * a/b/c => accepted
 */
int main() {
    map<pair<char, char>, vector<char>> transitionMetric;
    transitionMetric[make_pair('a', 'a')] = {'a'};
    transitionMetric[make_pair('a', 'b')] = {'b'};
    transitionMetric[make_pair('a', 'c')] = {'c'};
    transitionMetric[make_pair('b', 'a')] = {'a', 'b'};
    transitionMetric[make_pair('b', 'b')] = {'b', 'c'};
    transitionMetric[make_pair('b', 'c')] = {'c', 'a'};
    transitionMetric[make_pair('c', 'a')] = {'c'};
    transitionMetric[make_pair('c', 'b')] = {'b'};
    transitionMetric[make_pair('c', 'c')] = {'a'};
    unordered_set<char> acceptStat = { 'a' };
    vector<char> inputStat = { 'a', 'b', 'c' };
    cout << acceptStates(transitionMetric, acceptStat, inputStat) << "\n";
}
