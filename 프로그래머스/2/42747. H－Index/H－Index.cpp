#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    int n = citations.size();

    for (int h = n; h >= 0; h--) {
        int count = 0;

        for (int citation : citations) {
            if (citation >= h)
                count++;
        }

        if (count >= h)
            return h;
    }

    return 0;
}