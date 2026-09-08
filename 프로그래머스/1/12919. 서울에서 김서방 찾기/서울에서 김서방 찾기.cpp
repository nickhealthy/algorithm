#include<bits/stdc++.h>

using namespace std;

string solution(vector<string> seoul) {
    auto it = find(seoul.begin(), seoul.end(), "Kim");
    int idx = distance(seoul.begin(), it);
    
    return "김서방은 " + to_string(idx) + "에 있다";
}