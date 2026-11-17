import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] result = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    result[j]++;
                }
            }
        }
        
        int maxScore = 0;
        for (int i = 0; i < 3; i++) {
            maxScore = Math.max(maxScore, result[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (maxScore == result[i]) list.add(i + 1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}