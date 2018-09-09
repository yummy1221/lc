#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    vector<int> v = {1, 2, 3, 10, 0};
    priority_queue<int> pq(v.begin(), v.begin() + 4);
    
    cout << pq.top() << "\n";

}
