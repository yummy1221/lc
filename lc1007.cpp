class Solution {
public:
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        if (A.empty() && B.empty()) return 0;
        if (A.size() != B.size()) return -1;
        // cout << A.size() << "\n";

        // set up
        int rotate_a = 0;
        int rotate_b = 0;
        int a_same = 0;
        int b_same = 0;
        bool a_possible = true;
        bool b_possible = true;
        if (A[0] == B[0]) {
            a_same++;
            b_same++;
        }
        for (int i = 1; i < A.size(); ++i) {
            if (!a_possible && !b_possible) return -1;
            if (a_possible) {
                if (A[i] == A[0]) {
                    if (A[i] == B[i]) a_same++;
                } else if (B[i] == A[0]) {
                    rotate_a ++;
                } else {
                    a_possible = false;
                }
            }
            if (b_possible) {
                if (B[i] == B[0]) {
                    if (A[i] == B[i]) b_same++;
                } else if (A[i] == B[0]) {
                    rotate_b ++;
                } else {
                    b_possible = false;
                }
            }
        }
        
        // cout << a_possible << " " << b_possible << "\n";
        // cout << rotate_a << " " << rotate_b << "\n";
        // cout << a_same << " " << b_same << "\n";
        if (!a_possible && !b_possible) return -1;
        int rst = A.size();
        if (a_possible) {
            int rotate = static_cast<int>(A.size()) - rotate_a - a_same;
            if (rotate < 0) rotate = static_cast<int>(A.size());
            rst = min(rst, min(rotate_a, rotate));
        }
        if (b_possible) {
            int rotate = static_cast<int>(A.size()) - rotate_b - b_same;
            if (rotate < 0) rotate = static_cast<int>(A.size());
            rst = min(rst, min(rotate_b, static_cast<int>(A.size()) - rotate_b - b_same));
        }
        return rst;
    }
};
