#include <iostream>
#include <list>

int main() {
    using namespace std;

    list<int> a;
    a.push_back(1);
    a.push_back(2);
    a.push_back(3);
    a.push_back(4);
    a.push_back(5);
    a.push_back(6);
    list<int>::iterator it = a.begin();
    it++; it++; // *it = 3
    list<int>::iterator it_erase = it;
    it_erase--;
    a.erase(it_erase);
    for (auto x : a)
        cout << " " << x << "\n";
}
