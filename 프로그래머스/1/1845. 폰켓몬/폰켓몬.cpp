#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    const int MAX_SIZE = nums.size() / 2;
    
    unordered_map<int, int> data;
    for (int e: nums) {
        data[e]++;
    }
    
    unordered_map<int, int> map;
    for (auto [key, value]: data) {
        if (!map.contains(key)) {
            map[key]++;
        }
    }
    
    return (map.size() >= MAX_SIZE) ? MAX_SIZE : map.size();
}