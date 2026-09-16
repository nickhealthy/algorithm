#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) 
{   
    int write = 0;
    int n = (int)arr.size();
    for (int read = 1; read < n; read++) {
        if (arr[write] != arr[read]) {
            arr[++write] = arr[read];
        }
    }
    
    arr.resize(write + 1);

    return arr;
}

// unordered_set<pair>로 풀어보기

// vector<int> solution(vector<int> arr) 
// {
//     unorderd_set<pair<int, int>> us;
//     int n = arr.size();
//     for (int i = 0; i < n; i++) {
//         us.push({i, arr[i]});
//     }
    
//     sort(us.begin(), us.end());
    
//     vector<int> answer;
//     for (int i = 0; i < us.size(); i++) {
//         int value = us.front().first;
//         us.erase(us.front());
//         answer.push_back(value);
//     }
    
//     return answer;
// }