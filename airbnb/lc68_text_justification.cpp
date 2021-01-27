#include <iostream>
#include <vector>

using namespace std;

string compose(vector<string>& line, int clen, int maxWidth) {
    string empty(maxWidth, ' ');
    string rst = line[0];
    if (line.size() == 1) {
        return rst + empty.substr(0, maxWidth - rst.size());
    }
    int space = (maxWidth - clen) / (line.size() - 1);
    vector<int> spaces(line.size()-1, space);
    int remaining = maxWidth - clen - (line.size()-1) * space;
    for (int i = 0; i < remaining; ++i) {
        spaces[i] += 1;
    }
    for (int i = 1; i < line.size(); ++i) {
        rst += empty.substr(0, spaces[i-1]);
        rst += line[i];
    }

    return rst;
}

vector<string> fullJustify(vector<string>& words, int maxWidth) {
    vector<string> rst;
    vector<string> current;
    int clen = 0;
    for (int i = 0; i < words.size(); ++i) {
        if (clen + words[i].size() + current.size() > maxWidth) {
            rst.push_back(compose(current, clen, maxWidth));
            current.clear();
            clen = 0;
        }
        clen += words[i].size();
        current.push_back(words[i]);
        if (clen + current.size() - 1 == maxWidth) {
            rst.push_back(compose(current, clen, maxWidth));
            clen = 0;
            current.clear();
        }
    }
    if (!current.empty()) {
        string empty(maxWidth, ' ');
        string last;
        for (int i = 0; i < current.size(); ++i) {
            last += current[i] + " ";
        }
        last.pop_back();
        last += empty.substr(0, maxWidth - last.size());
        rst.push_back(last);
    }
    return rst;
}

int main()
{
    /*
    vector<string> words = { "This", "is", "an", "example", "of", "text", "justification." };
    int maxWidth = 16;
    */

    /*
    vector<string> words = {"What","must","be","acknowledgment","shall","be"};
    int maxWidth = 16;
    */

    vector<string> words = {"Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"};
    int maxWidth = 20;

    vector<string> rst = fullJustify(words, maxWidth);
    for (auto x : rst) {
        cout << "\"" << x << "\"\n";
    }
}
