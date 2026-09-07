#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    const int MAX_SIZE = nums.size() / 2;
    
    unordered_map<int, int> data;
    for (int e: nums) {
        data[e]++;
    }
    
    return min((int)data.size(), MAX_SIZE);
}