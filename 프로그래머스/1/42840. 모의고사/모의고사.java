import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 수포자 3명의 찍기 패턴을 2차원 배열로 묶기
        int[][] patterns = {
            {1, 2, 3, 4, 5},                  // 1번 수포자
            {2, 1, 2, 3, 2, 4, 2, 5},         // 2번 수포자 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}    // 3번 수포자 
        };

        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    int person = j + 1;
                    scoreMap.put(person, scoreMap.getOrDefault(person, 0) + 1);
                }
            }
        }
        
        int maxScore = 0;
        for (int score: scoreMap.values()) {
            maxScore = Math.max(maxScore, score);
        }
        
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            if (maxScore == scoreMap.getOrDefault(i, 0)) {
                list.add(i);
            }
        }
        
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}