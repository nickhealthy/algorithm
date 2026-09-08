#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    for (int i = 1; i <= n; i++) {
        int temp = 0;
        for (int j = 0 + i; j <= n; j++) {
            temp += j;
            if (temp > n) break;
            
            if (temp == n) {
                answer++;
                break;
            }
        }
    }
    
    return answer;
}