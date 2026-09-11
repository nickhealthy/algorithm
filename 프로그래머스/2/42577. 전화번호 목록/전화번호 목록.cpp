// /*
// // 1번쨰 풀이 - sort
// #include <bits/stdc++.h>

// using namespace std;

// bool solution(vector<string> phone_book) {
//     sort(phone_book.begin(), phone_book.end());

//     for (int i = 0; i < phone_book.size() - 1; i++) {
//         if (phone_book[i + 1].find(phone_book[i]) == 0) {
//             return false;
//         }
//     }
    
//     return true;
// }
// */


// // 2번째 풀이 - prefix
// #include <bits/stdc++.h>

// using namespace std;

// bool solution(vector<string> phone_book) {
//     unordered_set<string> phone_numbers(
//         phone_book.begin(),
//         phone_book.end()
//     );
    
//     for (string phone : phone_book) {
//         string prefix;
        
//         for (char c : phone) {
//             prefix += c;
        
//             if (prefix != phone && phone_numbers.contains(prefix)) {
//                 return false;
//             }
//         }
//     }    
    
//     return true;
// }

// /*
// // 3번째 방식 - 완탐(시간초과)
// #include <bits/stdc++.h>

// using namespace std;

// bool solution(vector<string> phone_book) {
//     const int PHONE_BOOK_SIZE = phone_book.size();
    
//     for (int i = 0; i < PHONE_BOOK_SIZE; i++) {
//         for (int j = 0; j < PHONE_BOOK_SIZE; j++) {
//             if (i == j) continue;
            
//             if (phone_book[j].find(phone_book[i]) == 0) {
//                 return false;
//             }
//         }
//     }
    
//     return true;
// }
// */

#include <bits/stdc++.h>

using namespace std;

bool solution(vector<string> phone_book) {
    unordered_set<string> s(phone_book.begin(), phone_book.end());

    for (const string& num: phone_book) {
        string prefix = "";
        for (char ch: num) {
            prefix += ch;
            
            if (prefix != num && s.count(prefix)) {
                return false;
            }
        }
    }
    
    return true;
}