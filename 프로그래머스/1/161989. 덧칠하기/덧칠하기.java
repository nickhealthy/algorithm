class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pos = section[0];
        
        for (int sec: section) {
            if (pos <= sec) {
                pos = m + sec;
                answer++;
            }
        }
        
        return answer;
    }
}