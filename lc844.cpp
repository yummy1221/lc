#include <iostream>

using namespace std;

bool backspaceCompare(string S, string T) {
    int sl = 0;
    int tl = 0;
    char sstr[S.size()+1];
    char tstr[T.size()+1];
    for (int i = 0; i < S.size(); ++i) {
        if (S[i] != '#') {
            sstr[sl++] = S[i];
        } else if (sl != 0) {
            sl--;
        }
    }
    for (int i = 0; i < T.size(); ++i) {
        if (T[i] != '#') {
            tstr[tl++] = T[i];
        } else if (tl != 0) {
            tl--;
        }
    }
    cout << "sl=" << sl << ", tl=" << tl << "\n";
    if (sl != tl) return false;
    sstr[sl] = '\0';
    tstr[tl] = '\0';
    cout << "sstr=" << string(sstr) << ", tstr=" << string(tstr) << "\n";
    return string(sstr) == string(tstr);
}

int main()
{
    string a = "y#fo##f";
    string b = "y#f#o##f";;
    cout << backspaceCompare(a, b) << "\n";
}
