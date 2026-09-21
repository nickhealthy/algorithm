// #include<bits/stdc++.h>

// using namespace std;

// vector<int> solution(vector<int> progresses, vector<int> speeds) {
//     vector<int> answer;
//     queue<pair<int, int>> queue;
    
//     int n = (int)progresses.size();
//     for (int i = 0; i < n; i++) {
//         queue.push({progresses[i], speeds[i]});
//     }
    
//     while (!queue.empty()) {
//         int qSize = (int)queue.size();
//         for (int i = 0; i < qSize; i++) {
//             auto [progress, speed] = queue.front(); queue.pop();
//             progress += speed;
//             queue.push({progress, speed});
//         }
        
//         if (queue.front().first >= 100) {
//             int count = 0;
//             //qSize = (int)queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 if (queue.front().first >= 100) {
//                     queue.pop();
//                     count++;
//                 }
//             }
            
//             answer.push_back(count);
//         }
//     }
    
//     return answer;
// }


// 2026.09.21 - index 변수 포인터 사용
// #include<bits/stdc++.h>

// using namespace std;

// vector<int> solution(vector<int> progresses, vector<int> speeds) {
//     vector<int> answer;
//     int head = 0, n = (int) progresses.size();
    
//     while (head < n) {
//         for (int i = head; i < n; i++) {
//             progresses[i] += speeds[i];
//         }
        
//         int cnt = 0;
//         while (head < n && progresses[head] >= 100) {
//             head++;
//             cnt++;
//         }
        
//         if (cnt) answer.push_back(cnt);
//     }
    
//     return answer;
// }

// 2026.09.21 - O(N) 풀이 (수식 보일 때)
#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int n = (int) progresses.size(), deployDay = 0;
    for (int i = 0; i < n; i++) {
        int day = (99 - progresses[i]) / speeds[i] + 1;
        
        // 현재 배포일보다 큰 값이면 다른 그룹으로 묶고, 
        if (answer.empty() || day > deployDay) {
            deployDay = day;
            answer.push_back(1);
        // 현재 배포일보다 작거나 같은 값이면 같은 그룹으로 묶기
        } else {
            answer.back()++;
        }
    }
    
    return answer;
}