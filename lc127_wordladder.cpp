#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <queue>
#include <vector>

using namespace std;

// comment out solutions for word ladder 1
// new line for word ladder 2

void getPath(vector<string>& path, int index, 
        const string& previousWord,
        const string& beginWord,
        const unordered_map<string, unordered_set<string> >& wordMap,
        vector<vector<string> >& rst)
{
    cout << "previousWord=" << previousWord
        << ", beginWord=" << beginWord
        << ", index=" << index << "\n";

    path[index] = previousWord;
    if (index == 0)
    {
        if (previousWord == beginWord)
            rst.push_back(path);
        return;
    }

    const unordered_set<string>& uset = wordMap.at(previousWord);
    for (unordered_set<string>::const_iterator cit = uset.cbegin();
            cit != uset.end(); ++cit)
    {
        getPath(path, index-1, *cit, beginWord, wordMap, rst);
    }
}


vector<vector<string>> ladderLength(string beginWord, string endWord, vector<string>& wordList)
{
    unordered_map<string, unordered_set<string> > wordMap;
    for (int i = 0; i < wordList.size(); i++)
    {
        if (wordList[i] == beginWord) continue;
        wordMap[wordList[i]] = unordered_set<string>();
    }

    vector<vector<string> > rst;
    if (wordMap.find(endWord) == wordMap.end()) return rst;

    // use iterative instead of recursive
    queue<string> q;
    q.push(beginWord);
    int count = 0;
    string front = beginWord;
    bool first = false;
    unordered_set<string> sameLevel;
    while (!q.empty())
    {
        string top = q.front();
        q.pop();
        if (front == top) 
        {
            sameLevel.clear();
            if (!wordMap[endWord].empty()) break;
            count++;
            first = true;
        }
        string begin = top;
        for (int i = 0; i < begin.size(); ++i)
        {
            begin = top;
            for (char j = 'a'; j <= 'z'; ++j)
            {
                begin[i] = j;
                if ( wordMap.find(begin) != wordMap.end() && 
                        (sameLevel.find(begin) != sameLevel.end() || wordMap[begin].empty()) )
                {
                    if (first)
                    {
                        front = begin;
                        first = false;
                    }
                    if (sameLevel.find(begin) == sameLevel.end() && begin != endWord)
                    {
                        q.push(begin);
                    }
                    wordMap[begin].insert(top);
                    sameLevel.insert(begin);
                }
            }
        }
    }

    string path;

    if (!wordMap[endWord].empty())
    {
        vector<string> path(count+1);
        getPath(path, count, endWord, beginWord, wordMap, rst);
    }
    return rst;
}


int main()
{
    cout << "lc 127 word ladder \n";

    /*
    string beginWord = "hit";
    string endWord = "cog";
    vector<string> wordList;
    wordList.push_back("hot");
    wordList.push_back("dot");
    wordList.push_back("dog");
    wordList.push_back("lot");
    wordList.push_back("log");
    wordList.push_back("cog");
    */
    string beginWord = "hot";
    string endWord = "dog";
    vector<string> wordList;
        //["hot","cog","dog","tot","hog","hop","pot","dot"]
    wordList.push_back("hot");
    wordList.push_back("cog");
    wordList.push_back("dog");
    wordList.push_back("tot");
    wordList.push_back("hog");
    wordList.push_back("hop");
    wordList.push_back("pot");
    wordList.push_back("dot");

    /*
    string beginWord = "a";
    string endWord = "c";
    vector<string> wordList;
    wordList.push_back("a");
    wordList.push_back("b");
    wordList.push_back("c");
    */

    /*
    string beginWord = "red";
    string endWord = "tax";
    vector<string> wordList;
    wordList.push_back("ted");
    wordList.push_back("tex");
    wordList.push_back("red");
    wordList.push_back("tax");
    wordList.push_back("tad");
    wordList.push_back("den");
    wordList.push_back("rex");
    wordList.push_back("pee");
    */

    /*
    string tmp[] = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
    string beginWord = "cet";
    string endWord = "ism";
    vector<string> wordList;
    for (int i = 0; i < 599; ++i)
        wordList.push_back(tmp[i]);
    */

    vector<vector<string>> rst = ladderLength(beginWord, endWord, wordList);
    for (int i = 0; i < rst.size(); ++i)
    {
        for (int j = 0; j < rst[i].size(); ++j)
        {
            cout << rst[i][j] << ", ";
        }
        cout << "\n";
    }
}
