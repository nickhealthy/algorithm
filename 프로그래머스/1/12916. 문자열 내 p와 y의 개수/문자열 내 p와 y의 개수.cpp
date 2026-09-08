#include<bits/stdc++.h>
using namespace std;

bool solution(string s)
{
    transform(s.begin(), s.end(), s.begin(), ::toupper);
    auto countP = count(s.begin(), s.end(), 'P');
    auto countY = count(s.begin(), s.end(), 'Y');
    
    
    return countP == countY ? true : false;
}