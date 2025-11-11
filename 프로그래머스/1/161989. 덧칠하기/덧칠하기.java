class Solution {
    public int solution(int n, int m, int[] section) {
        /**
        int answer = 0;
        int pos = section[0];
        
        for (int sec: section) {
            if (pos <= sec) {
                pos = m + sec;
                answer++;
            }
        }
        
        return answer;
        */
        int answer = 1;
        int pos = section[0];
        
        for (int i = 0; i < section.length; i++) {
            if (pos + m - 1 < section[i]) {
                answer++;
                pos = section[i];
            }
        }
        
        return answer;
    }
}