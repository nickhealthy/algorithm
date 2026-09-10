#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(vector<int> numbers) {
    vector<string> string_numbers;
    
    for (auto number: numbers) {
        string_numbers.push_back(to_string(number));
    }
    
    sort(string_numbers.begin(), string_numbers.end(), [](const string& a, const string& b) {
       return a + b > b + a; 
    });
    
    string answer = "";
    for (auto s: string_numbers) {
        answer += s;
    }
   
    return (answer[0] == '0') ? "0" : answer;
}