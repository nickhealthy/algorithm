// #include <string>
// #include <vector>
// #include <queue>

// using namespace std;

// int solution(int bridge_length, int weight, vector<int> truck_weights) {
//     queue<int> bridge;
//     for (int i = 0; i < bridge_length; i++) {
//         bridge.push(0);
//     }
    
//     int currWeight = 0;
//     int time = 0;
//     int idx = 0; // 다리에 올라갈 truck 위치
    
//     int n = (int)truck_weights.size();
//     while (idx < n) {
//         time++;
        
//         currWeight -= bridge.front();
//         bridge.pop();
        
//         if (currWeight + truck_weights[idx] <= weight) {
//             currWeight += truck_weights[idx];
//             bridge.push(truck_weights[idx]);
//             idx++;
//         } else {
//             bridge.push(0); // 다리의 무게가 트럭의 무게를 버티지 못 할 경우
//         }
//     }
    
//     // 마지막 트럭까지 큐에 들어간 순간, 다리 위에 남은 트럭은 bridge_length 시간 뒤에 모두 빠져나감
//     // time += bridge_length;
    
//     return time;
// }

#include <bits/stdc++.h>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<int> bridge;
    for (int i = 0; i < bridge_length; i++) {
        bridge.push(0);
    }
    
    int time = 0;
    int currWeight = 0;
    int idx = 0;
    int n = truck_weights.size();
    
    while (idx < n) {
        time++;
        
        currWeight -= bridge.front();
        bridge.pop();
        
        if (currWeight + truck_weights[idx] <= weight) {
            currWeight += truck_weights[idx];
            bridge.push(truck_weights[idx]);
            idx++;
        } else {
            bridge.push(0);
        }
    }
    
    time += bridge_length;
    
    return time;
}