#include<bits/stdc++.h>

using namespace std;

// pair 자료형으로 {각 문자의 n 번쨰 문자, index}
// p.first 기준으로 pair 정렬
// p.second로 실제 정렬
vector<string> solution(vector<string> strings, int n) {
    vector<pair<char, string>> v;
    
    for (int i = 0; i < strings.size(); i++) {
        v.push_back({strings[i][n], strings[i]});
    }
    
    sort(v.begin(), v.end());
        
    vector<string> answer;
    for (const auto& p: v) {
        answer.push_back(p.second);
    }
    
    return answer;
}