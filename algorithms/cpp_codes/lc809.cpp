// Sometimes people repeat letters to represent extra feeling, such as 
// "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo",
// we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

// For some given string S, a query word is stretchy if it can be made to be
// equal to S by any number of applications of the following extension operation:
// choose a group consisting of characters c, and add some number of characters c 
// to the group so that the size of the group is 3 or more.

// For example, starting with "hello", we could do an extension on the group "o" 
// to get "hellooo", but we cannot get "helloo" since the group "oo" has size 
// less than 3.  Also, we could do another extension like "ll" -> "lllll" to 
// get "helllllooo".  If S = "helllllooo", then the query word "hello" would 
// be stretchy because of these two extension operations: 
// query = "hello" -> "hellooo" -> "helllllooo" = S.

// Given a list of query words, return the number of words that are stretchy. 

class Solution {
public:
    int expressiveWords(string S, vector<string>& words) {
        int rst = 0;
        for (int i = 0; i < words.size(); ++i) {
            // cout << words[i] << " " << stretchy(S, words[i]) << "\n";
            rst += stretchy(S, words[i]);
        }
        return rst;
    }

private:
    int stretchy(string s, string w) {
        int s_i = 0;
        int s_j = 0;
        int w_i = 0;
        int w_j = 0;
        while (w_i < w.size() && s_i < s.size()) {
            if (s[s_i] != w[w_i]) return 0;
            while (s_j < s.size() && s[s_j] == s[s_i]) s_j++;
            while (w_j < w.size() && w[w_j] == w[w_i]) w_j++;
            if ((s_j - s_i < w_j - w_i)) return 0;
            if ((s_j - s_i > w_j - w_i) && (s_j - s_i < 3)) return 0;
            s_i = s_j;
            w_i = w_j;
        }
        return (s_i == s.size() && w_i == w.size());
    }
};
