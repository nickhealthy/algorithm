#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    int n = citations.size();
    
    // 논문 총 개수 n개 보다 h가 클 수 없음
    for (int h = n; h >= 0; h--) {
        int count = 0;
        
        for (int citation: citations) {
            if (citation >= h) {
                count++;
                
                if (count >= h) {
                    return h;
                }
            }
        }
    }

    return 0;
}