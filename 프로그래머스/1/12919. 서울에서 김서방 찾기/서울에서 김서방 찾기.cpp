#include<bits/stdc++.h>

using namespace std;

string solution(vector<string> seoul) {
//     auto it = find(seoul.begin(), seoul.end(), "Kim");
//     int idx = distance(seoul.begin(), it);
    
//     return "김서방은 " + to_string(idx) + "에 있다";
    
    for (auto it = seoul.begin(); it != seoul.end(); it++) {
        if (*it == "Kim") {
            return "김서방은 " + to_string(it - seoul.begin()) + "에 있다";
        }
    }
}