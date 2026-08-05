import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        List<Integer> maxList = new ArrayList();
        List<Integer> minList = new ArrayList();
        for (int i = 0; i < sizes.length; i++) {
            maxList.add(Math.max(sizes[i][0], sizes[i][1]));
            minList.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return Collections.max(maxList) * Collections.max(minList);
    }
}