import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (q.isEmpty() || q.peekLast() != num) {
                q.offer(num);
            }
        }
        
        
        int[] answer = new int[q.size()];
        int idx = 0;
        while (!q.isEmpty()) {
            answer[idx++] = q.poll();
        }
        
        return answer;
    }
}