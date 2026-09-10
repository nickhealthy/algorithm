// #include <string>
// #include <vector>
// #include <bits/stdc++.h>

// using namespace std;

// vector<int> solution(vector<int> array, vector<vector<int>> commands) {
//     vector<int> answer;
    
//     for (auto command: commands) {
//         int i = command[0];
//         int j = command[1];
//         int k = command[2];
        
//         vector<int> temp;
//         for (int idx = i - 1; idx < j; idx++) {
//             temp.push_back(array[idx]);
//         }
        
//         sort(temp.begin(), temp.end());
        
//         answer.push_back(temp[k - 1]);
//     }

//     return answer;
// }

#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for (vector<int> command: commands) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        
        vector<int> temp;
        for (int idx = i - 1; idx < j; idx++) {
            temp.push_back(array[idx]);
        }
        
        sort(temp.begin(), temp.end());
        answer.push_back(temp[k - 1]);
    }
    
    
    return answer;
}