#include <bits/stdc++.h>

using namespace std;


bool solution(string s) {
    stack<int> st;
    
    for (int i = 0; i < (int) s.length(); i++) {
        char ch = s[i];
        if (!st.empty() && ch == ')' && st.top() == '(') {
            st.pop();
        } else {
            st.push(ch);
        }
    }
    
    if (st.empty()) return true;

    return false;
}