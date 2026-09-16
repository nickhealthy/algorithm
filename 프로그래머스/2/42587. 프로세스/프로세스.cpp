// #include <string>
// #include <vector>
// #include <queue>

// using namespace std;

// int solution(vector<int> priorities, int location) {
//     queue<pair<int, int>> q;
    
//     int n = priorities.size();
//     for (int i = 0; i < n; i++) {
//         q.push({priorities[i], i});
//     }
    
//     int executed_count = 0;
//     vector<pair<int, int>> answer;
    
//     while (!q.empty()) {
//         auto priority = q.front(); q.pop();
        
//         bool has_higher = false;
//         for (int i = 0; i < q.size(); i++) {
//             auto temp = q.front(); q.pop();
            
//             if (priority.first < temp.first)
//                 has_higher = true;
            
//             q.push(temp);
//         }
        
//         if (has_higher) {
//             q.push(priority);
//         } else {
//             executed_count++;
//             if (priority.second == location) {
//                 return executed_count;
//             }
//         }
//     }
    
//     return -1;
// }

// #include <string>
// #include <vector>
// #include <queue>

// using namespace std;

// struct Cmp {
//     bool operator()(const pair<int,int>& a, const pair<int,int>& b) {
//         if (a.first != b.first) return a.first < b.first;
//         return a.second > b.second;  // 동점이면 index 작은 게 먼저 나오도록
//     }
// };

// int solution(vector<int> priorities, int location) {
//     priority_queue<pair<int,int>, vector<pair<int,int>>, Cmp> pq;
    
//     int n = priorities.size();
//     for (int i = 0; i < n; i++) {
//         pq.push({priorities[i], i});
//     }
    
//     int executed_count = 0;
//     while (!pq.empty()) {
//         auto cur = pq.top(); pq.pop();
//         executed_count++;
//         if (cur.second == location) {
//             return executed_count;
//         }
//     }
    
//     return -1;
// }

#include <bits/stdc++.h> 

using namespace std;

int solution(vector<int> priorities, int location) {
    queue<pair<int, int>> q;
    
    int n = priorities.size();
    for (int pos = 0; pos < n; pos++) {
        q.push(pair<int, int>(priorities[pos], pos));
    }
    
    int executedCount = 0;
    while (!q.empty()) {
        auto cur = q.front(); q.pop();
        
        int qSize = q.size();
        bool hasHigher = false;
        for (int i = 0; i < qSize; i++) {
            auto nextCur = q.front(); q.pop();
            
            if (cur.first < nextCur.first) {
                hasHigher = true;
            }
            q.push(nextCur);
        }
        
        if (hasHigher) {
            q.push(cur);
            continue;
        }
        
        executedCount++;
        if (cur.second == location) return executedCount;
    }
    
    
    return -1;
}