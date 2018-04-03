#include <iostream>
#include <map>
#include <sstream>

using namespace std;

string originalDigits(string s)
{
    const int NUM_CHARS = 26;
    int chars[NUM_CHARS];
    for (int i = 0; i < NUM_CHARS; ++i) chars[i] = 0;
    for (int i = 0; i < s.size(); ++i) chars[s[i]-'a']++;

    const int NUM_DIGITS = 10;
    int digits[NUM_DIGITS];
    for (int i = 0; i < NUM_DIGITS; ++i) digits[i] = 0;
    map<char, int> digitsToString;
    string numstr[] = { "zero", "one", "two", "three", "four", 
        "five", "six", "seven", "eight", "nine" };

    // first round
    // z - 0, w - 2, u - 4, x - 1, g - 8
    map<char, int> uniqueCharToDigits;
    uniqueCharToDigits['z'] = 0;
    uniqueCharToDigits['w'] = 2;
    uniqueCharToDigits['u'] = 4;
    uniqueCharToDigits['x'] = 6;
    uniqueCharToDigits['g'] = 8;
    for (std::map<char, int>::iterator it = uniqueCharToDigits.begin();
            it != uniqueCharToDigits.end(); ++it)
    {
        int d = it->second;
        int count = chars[(it->first)-'a'];
        digits[d] = count;
        for (int i = 0; i < numstr[d].size(); ++i)
        {
            chars[numstr[d][i]-'a'] = chars[numstr[d][i]-'a'] - count;
        }
    }

    // second
    map<char, int> uniqueCharToDigits2;
    uniqueCharToDigits2['o'] = 1;
    uniqueCharToDigits2['t'] = 3;
    uniqueCharToDigits2['f'] = 5;
    uniqueCharToDigits2['s'] = 7;

    for (std::map<char, int>::iterator it = uniqueCharToDigits2.begin();
            it != uniqueCharToDigits2.end(); ++it)
    {
        int d = it->second;
        int count = chars[(it->first)-'a'];
        digits[d] = count;
        for (int i = 0; i < numstr[d].size(); ++i)
        {
            chars[numstr[d][i]-'a'] = chars[numstr[d][i]-'a'] - count;
        }
    }
    digits[9] = chars['i'-'a'];

    std::ostringstream oss;
    for (int i = 0; i < NUM_DIGITS; ++i)
    {
        for (int j = 0; j < digits[i]; ++j)
        {
            oss << i;
        }
        cout << "num of " << i << "s=" << digits[i] << "\n";
    }
    return oss.str();
}

void getUniqueChars(string digits[], int len)
{
    int chars[26];
    for (int i = 0; i < 26; ++i) chars[i] = 0;
    for (int i = 0; i < len; ++i)
    {
        for (int j = 0; j < digits[i].size(); ++j)
        {
            chars[digits[i][j]-'a']++;
        }
    }

    for (int i = 0; i < 26; ++i)
    {
        char c = i + 'a';
        if (chars[i] == 1) cout << "****** ";
        cout << c << "=" << chars[i] << "\n";
    }
}

int main()
{
    /*
    string digits[] = {
        "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "zero"
    };
    string digits2[] = { "one", "three", "five", "seven", "nine" };
    getUniqueChars(digits2, 5);
    */
    string s = "fviefuro";
    cout << originalDigits(s) << "\n";
}
