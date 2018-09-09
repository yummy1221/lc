#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
    string a = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    vector<string> input_split;
    size_t pos0 = 0;
    size_t pos = a.find('\n');
    while (pos != string::npos)
    {
        string fname = a.substr(pos0, pos-pos0);
        input_split.push_back(fname);

        pos0 = pos + 1;
        pos = a.find('\n', pos0);
    }
    input_split.push_back(a.substr(pos0));

    stack<pair<int, string> > paths;
    int paths_name_len = 0;
    int length = 0;
    for (vector<string>::iterator it = input_split.begin();
            it != input_split.end(); ++it)
    {
        string fname = *it;
        int tab = 0;
        while(fname[tab] == '\t') tab++;
        fname = fname.substr(tab);

        while (!paths.empty() && paths.top().first >= tab) {
            paths_name_len = paths_name_len - paths.top().second.size();
            paths.pop();
        }

        if (fname.find('.') != string::npos) // This is a file name
        {
            int cur_len = paths_name_len + paths.size() + fname.size();
            if (cur_len > length) length = cur_len;
        }
        else // This is a folder name
        {
            paths.push(make_pair(tab, fname));
            paths_name_len += fname.size();
        }
    }
    cout << "rst=" << length << "\n";
}
