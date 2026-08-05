import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 수포자 3명의 찍기 패턴을 2차원 배열로 묶기
        int[][] patterns = {
            {1, 2, 3, 4, 5},                  // 1번 수포자
            {2, 1, 2, 3, 2, 4, 2, 5},         // 2번 수포자 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}    // 3번 수포자 
        };

        int[] scoreArr = new int[patterns.length];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scoreArr[j]++;
                }
            }
        }
        
        // 가장 높은 점수를 받은 사람 집계
        int maxScore = 0;
        for (int i = 0; i < scoreArr.length; i++) {
            maxScore = Math.max(maxScore, scoreArr[i]);
        }
        
        List<Integer> list = new ArrayList();
        for (int i = 0; i < scoreArr.length; i++) {
            if (maxScore == scoreArr[i]) {
                list.add(i + 1);
            }
        }
        
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}