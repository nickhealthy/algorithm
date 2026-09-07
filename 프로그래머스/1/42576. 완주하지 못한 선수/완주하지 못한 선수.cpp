#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> participantMap;
    
    for (string p: participant) {
        participantMap[p]++;
    }
    
    for (string c: completion) {
        participantMap[c]--;
    }
    
    string answer = "";
    for (auto [key, value]: participantMap) {
        if (value != 0) answer = key;
    }
    
    return answer;
}

