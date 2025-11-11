import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // 1번 - List 사용
        /**
        int[] answer = new int[score.length];
        
        // 순위를 담을 List 선언
        List<Integer> rank = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            rank.add(score[i]);
            
            if (rank.size() > k) {
                rank.remove(Collections.min(rank));
            }
            
            answer[i] = Collections.min(rank);
        
        }
        return answer;
        */
        
        // 2번 - PriorityQueue 사용
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            q.add(score[i]);
            
            if (q.size() > k)
                q.poll();
            
            answer[i] = q.peek();
        }
        
        return answer;
    }
}