#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    queue<pair<int, int>> q;
    
    int n = priorities.size();
    for (int i = 0; i < n; i++) {
        q.push({priorities[i], i});
    }
    
    int executed_count = 0;
    vector<pair<int, int>> answer;
    
    while (!q.empty()) {
        auto priority = q.front(); q.pop();
        
        bool has_higher = false;
        for (int i = 0; i < q.size(); i++) {
            auto temp = q.front(); q.pop();
            
            if (priority.first < temp.first)
                has_higher = true;
            
            q.push(temp);
        }
        
        if (has_higher) {
            q.push(priority);
        } else {
            executed_count++;
            if (priority.second == location) {
                return executed_count;
            }
        }
    }
    
    return -1;
}