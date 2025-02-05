import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
        // [0]: emergency, [1]: orginalIndex
        int[][] emergencyWithIndexed = new int[emergency.length][2];
        
        // 인덱스와 응급도값 정렬하기
        for(int i = 0; i < emergency.length; i++) {
            emergencyWithIndexed[i][0] = emergency[i];
            emergencyWithIndexed[i][1] = i;
        }
        
        // 응급도 값을 기준으로 내림차순 정렬
        Arrays.sort(emergencyWithIndexed, (o1, o2) -> Integer.compare(o2[0], o1[0]));
        
        // 이미 응급도 값을 기준으로 내림차순 정렬 + 그 해당 INDEX를 알고 있기 때문에 매 loop시 순위가 보장됨
        int[] result = new int[emergency.length];
        for(int rank = 0; rank < emergency.length; rank++) {
            int orginalIndex = emergencyWithIndexed[rank][1];
            result[orginalIndex] = rank + 1; // 1위부터 시작해야하므로 +1 추가
        }
        
        return result;
    }
}