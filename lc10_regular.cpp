# include <iostream>
# include <stack>

using namespace std;

bool isMatch(string s, string p, int is, int ip)
{
    //std::cout << "is=" << is << ", ip=" << ip << "\n";
    if (ip < 0)
    {
        if (is < 0) return true;
        return false;
    }
    if (is < 0)
    {
        if (p[ip] == '*')
            return isMatch(s, p, is, ip-2);
        return false;

    }
    if (p[ip] == '*')
    {
        if (ip < 1) return false;
        if (p[ip-1] != '.' && s[is] != p[ip-1])
            return isMatch(s, p, is, ip-2);
        return (isMatch(s, p, is, ip-2) || isMatch(s, p, is-1, ip-2) || isMatch(s, p, is-1, ip));
    }
    else 
    {
        while(ip >= 0 && is >= 0 && p[ip] != '*')
        {
            if (p[ip] != '.' && p[ip] != s[is]) return false;
            ip--;
            is--;
        }
        return isMatch(s, p, is, ip);
    }
}

bool isMatch(string s, string p)
{
    int is = s.size() - 1;
    int ip = p.size() - 1;
    return isMatch(s, p, is, ip);
}

bool isMatchDP(string s, string p)
{
    int is = s.size();
    int ip = p.size();
    int dp[is+1][ip+1];
    int i = is - 1, j = ip - 1;
    for (int m = 0; m <= is; m++)
        for (int n = 0; n <= ip; n++)
            dp[m][n] = 0;
    dp[is][ip] = 1;

    while (j >= 0)
    {
        for (int i = is-1; i >= -1; --i) // i=-1 in case s is empty and p is x*
        {
            if (dp[i+1][j+1])
            {
                std::cout << "i=" << i << ", j=" << j << "\n";
                if (p[j] == '*')
                {
                    dp[i+1][j-1] = 1;
                    while (i >= 0 && (p[j-1] == '.' || s[i] == p[j-1]))
                        dp[i--][j-1] = 1;
                }
                else
                {
                    if (i >= 0 && (p[j] == '.' || p[j] == s[i]))
                    {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        if (p[j] == '*') j = j - 2;
        else j--;
    }
    return dp[0][0];
    
}

int main()
{
    string s = "caaaabbbbbababa";
    string p = "c*abb*bb*a.*b*.a*";
    std::cout << isMatchDP("", "c*") << "\n";
    //std::cout << isMatchDP("aab", "c*a*b") << "\n";
    //std::cout << isMatch("aab", "c*a*b") << "\n";
    /*
    std::cout << isMatchDP(s, p) << "\n";
    std::cout << isMatch(s, p) << "\n";
    std::cout << isMatchDP("aa", "aa") << "\n";
    std::cout << isMatch("aa", "aa") << "\n";
    std::cout << isMatchDP("a", ".*..") << "\n";
    std::cout << isMatch("a", ".*..") << "\n";
    std::cout << isMatchDP("abcksjdlf", ".*") << "\n";
    std::cout << isMatch("abcksjdlf", ".*") << "\n";
    */
}
