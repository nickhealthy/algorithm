#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> map;
    
    for (vector<string> cloth: clothes) {
        map[cloth[1]]++;
    }
    
    int answer = 1;
    for (auto [k ,v]: map) {
        answer = answer * (v + 1);
    }
    
    return answer - 1;
}