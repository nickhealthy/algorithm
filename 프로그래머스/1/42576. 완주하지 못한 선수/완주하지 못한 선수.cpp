#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> um;
    
    for (string p: participant) {
        um[p]++;
    }
    
    for (string c: completion) {
        um[c]--;
    }
    
    for (auto [key, value]: um) {
        if (um[key] == 1) return key;
    }
}