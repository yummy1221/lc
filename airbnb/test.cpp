#include <iostream>

using namespace std;

class Base {
public:
    Base() { test(); }
    virtual void test() { cout << "Base::test\n"; }
    void f() { test(); }
};

class Child : public Base {
    void test() { cout << "Child::test\n"; }
};

int main() {
    Base* b = new Child();
    b->test();
    b->f();
}
