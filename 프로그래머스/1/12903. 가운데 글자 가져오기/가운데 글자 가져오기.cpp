#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int len = s.length();
    int mid = len / 2;
    
    // 홀수면 중앙 문자 1개, 짝수면 중앙 앞문자 + 중앙 문자
    if (len % 2 == 1) {
        return string(1, s[mid]);
    } else {
        return string() + s[mid - 1] + s[mid]; 
    }
}