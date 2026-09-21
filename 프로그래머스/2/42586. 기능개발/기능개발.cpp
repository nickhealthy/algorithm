#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<pair<int, int>> queue;
    
    int n = (int)progresses.size();
    for (int i = 0; i < n; i++) {
        queue.push({progresses[i], speeds[i]});
    }
    
    while (!queue.empty()) {
        int qSize = (int)queue.size();
        for (int i = 0; i < qSize; i++) {
            auto [progress, speed] = queue.front(); queue.pop();
            progress += speed;
            queue.push({progress, speed});
        }
        
        if (queue.front().first >= 100) {
            int count = 0;
            qSize = (int)queue.size();
            for (int i = 0; i < qSize; i++) {
                if (queue.front().first >= 100) {
                    queue.pop();
                    count++;
                }
            }
            
            answer.push_back(count);
        }
    }
    
    return answer;
}