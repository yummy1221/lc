#include <iostream>
#include <sstream>
#include <unordered_map>
#include <unordered_set>

using namespace std;

bool wordPattern(string pattern, string str)
{
    int idx = 0;
    istringstream iss(str);
    string word;
    unordered_map<char, string> pmap;
    unordered_set<string> wordmap;
    while (iss >> word) {
        if (idx >= pattern.size()) return false;
        if (pmap.find(pattern[idx]) == pmap.end()) {
            pmap[pattern[idx]] = word;
            if (wordmap.find(word) != wordmap.end()) return false;
            wordmap.insert(word);
        } else {
            if (pmap[pattern[idx]] != word) return false;
        }
        idx++;
    }
    return idx == pattern.size();
}

int main()
{
    // both result should be false
    string str = "dog dog dog dog";
    string pattern = "abba";
    cout << wordPattern(pattern, str) << "\n";

    str = "dog cat cat dog";
    pattern = "aaaa";
    cout << wordPattern(pattern, str) << "\n";
}
