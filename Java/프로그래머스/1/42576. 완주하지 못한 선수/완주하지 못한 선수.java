// import java.util.*;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";

//         Map<String, Integer> map = new HashMap<>();
//         for (int i = 0; i < completion.length; i++) {
//             map.put(completion[i], 1);
//         }

//         for (int i = 0; i < completion.length; i++) {
//             if (!(map.containsKey(participant[i]))) {
//                 answer = participant[i];
//             }
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";

//         Map<String, Integer> map = new HashMap<>();
//         for(String name: participant) map.put(name, map.getOrDefault(name, 0) + 1);

//         for(String name: completion) {
//             map.put(name, map.get(name) - 1);
//         }

//         for(String key: map.keySet()) {
//             if (map.get(key) != 0) {
//                 answer = key;
//             }
//         }

//         return answer;
//  }
    
    public String solution(String[] participant, String[] completion) {
        /**
         * 문제 해결 전략
         *
         * 1. participant 선수 명단을 루프로 돌면서 해시맵에 key로 잡고 count
         * 2. completion 선수 명단을 루프로 돌면서 해시맵에 저장된 key를 조회 및 count -1
         * 3. 만약 루프를 돌면서 해시맵에 저장된 선수의 count가 0이라면 해당 키를 삭제
         * 4. 최종적으로 한명의 선수를 도출
         */

        Map<String, Integer> map = new HashMap<>();
        for (String key : participant) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : completion) {
            if (map.get(key) != 0) {
                map.put(key, map.get(key) - 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return "ERROR";
    }
}
