#include <iostream>
#include <vector>
#include <sstream>
#include <cmath>

using namespace std;

string toString(long ip_long, int mask) {
    string rst = "";
    vector<int> ips(4);
    for (int i = 0; i < 4; i++) {
        ips[4-i-1] = ip_long % 256;
        ip_long /= 256;
    }

    for (int i = 0; i < 3; i++) {
        rst = rst + to_string(ips[i]) + ".";
    }
    rst += to_string(ips[3]);
    rst += "/";
    return rst + to_string(mask);
}

vector<string> ipRepresentation(string ip, int num) {
    vector<string> rst;
    istringstream iss(ip);
    string ip_sub;
    long ip_long = 0;
    while (getline(iss, ip_sub, ',')) {
        ip_long = (ip_long << 8) + stoi(ip_sub);
    }

    while (num > 0) {
        long last_one = ip_long & (-ip_long);
        int zeros = log(last_one) / log(2);
        string s;
        if ((int)pow(2, zeros) > num) {
            int last_mask = log(num) / log(2);
            s = toString(ip_long, 32 - last_mask);
            ip_long += pow(2, last_mask);
            num -= pow(2, last_mask);
        } else {
            s = toString(ip_long, 32 - log(last_one) / log(2));
            ip_long += last_one;
            num -= last_one;
        }
        rst.push_back(s);
    }

    return rst;
}

int main()
{
    vector<string> rst = ipRepresentation("128, 0, 0, 4", 10);
    for (auto x : rst) {
        cout << x << "\n";
    }
}
