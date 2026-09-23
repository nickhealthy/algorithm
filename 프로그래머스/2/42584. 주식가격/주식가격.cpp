#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    int n = prices.size();
    vector<int> answer(n, 0);
    stack<int> st;
    
    for (int j = 0; j < n; j++) {
        while (!st.empty() && prices[st.top()] > prices[j]) {
            int i = st.top();
            st.pop();
            answer[i] = j - i;
        }
        st.push(j);
    }
    
    while (!st.empty()) {
        int i = st.top();
        st.pop();
        answer[i] = (n - 1) - i;
    }
    
    return answer;
    
    return answer;
}