// #include <string>
// #include <vector>

// using namespace std;

// bool solution(string s) {
//     int n = s.size();
    
//     if (n != 4 && n != 6) return false;
    
    
//     for (int i = 0; i < n; i++) {
//         if (!(s[i] >= '0' && s[i] <= '9')) {
//             return false;
//         }
//     }
    
//     return true;
// }

#include <bits/stdc++.h>

using namespace std;

bool solution(string s) {
    int n = s.size();
    
    if (n != 4 && n != 6) return false;
    
    return all_of(s.begin(), s.end(), ::isdigit);
}