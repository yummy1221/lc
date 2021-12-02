#include <iostream>
#include <sstream>
#include <unordered_map>
#include <unordered_set>

using namespace std;

// DFS
bool wordPattern(string pattern, string str, int is, int ip,
        unordered_map<char, string>& pmap, unordered_set<string>& words)
{
    if (is == str.size() && ip == pattern.size()) return true;
    if (is == str.size() || ip == pattern.size()) return false;

    if (pmap.find(pattern[ip]) != pmap.end()) {
        string pword = pmap[pattern[ip]];
        if (is + pword.size() > str.size()) return false;
        if (str.substr(is, pword.size()) != pword) return false;
        return wordPattern(pattern, str, is + pword.size(), ip + 1, pmap, words);
    }

    for (int i = is; i < str.size() - pattern.size() + ip + 1; i++) {
        string word = str.substr(is, i - is + 1);
        if (words.find(word) != words.end()) continue;  // if not continue, 2 char will map to the same string
        words.insert(word);
        pmap[pattern[ip]] = word;
        if (wordPattern(pattern, str, i+1, ip+1, pmap, words)) return true;
        words.erase(words.find(word));
        pmap.erase(pmap.find(pattern[ip]));
    }
    return false;
}

bool wordPattern(string pattern, string str)
{
    unordered_map<char, string> pmap;
    unordered_set<string> words;
    return wordPattern(pattern, str, 0, 0, pmap, words);
}

int main()
{
    string str = "redblueredblue";
    string pattern = "abab";
    cout << wordPattern(pattern, str) << "\n";

    // both result should be false
    str = "dog dog dog dog";
    pattern = "abba";
    cout << wordPattern(pattern, str) << "\n";

    str = "dog cat cat dog";
    pattern = "aaaa";
    cout << wordPattern(pattern, str) << "\n";
}
