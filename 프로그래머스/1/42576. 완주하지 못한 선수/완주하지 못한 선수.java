import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
//         Map<String, Integer> participantMap = new HashMap();
        
//         for (String str: participant) {
//             participantMap.put(str, participantMap.getOrDefault(str, 0) + 1);
//         }
        
//         for (String str: completion) {
//             participantMap.put(str, participantMap.get(str) - 1);
//         }
        
//         String answer = "";
//         for (String str: participantMap.keySet()) {
//             if (participantMap.get(str) > 0) {
//                 answer = str;
//             }
//         }
        
//         return answer;
        
        Map<String, Integer> participantMap = new HashMap();
        for (String name: participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }
        
        for (String name: completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }
        
        String answer = "";
        for (String name: participantMap.keySet()) {
            if (participantMap.get(name) == 1) {
                answer = name;
            }
        }
        
        return answer;
    }
}