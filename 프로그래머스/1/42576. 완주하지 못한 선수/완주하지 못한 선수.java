import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String p: participant) map.merge(p, 1, Integer::sum);
        for (String c: completion) map.merge(c, -1, Integer::sum);
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if (e.getValue() > 0) return e.getKey();
        }
        
        return "";
    }
}