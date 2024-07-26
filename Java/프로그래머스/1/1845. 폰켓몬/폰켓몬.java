import java.util.*;

class Solution {
    public int solution(int[] nums) {
//          int answer = 0;
//         int count = nums.length / 2;
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(map.get(nums[i]), 0) + 1);
//         }

// //        System.out.println(map.size());
//         // nums / 2 만큼만 가져갈 수 있다.
//         // 누구꺼를 가져갔는지 체크해야하는데..
//         // 그냥 루프만 돌면 되지 않을까?
//         if (map.size() >= count) {
//             answer = count;
//         } else if (map.size() < count) {
//             answer = map.size();
//         }

//         return answer;
        
        /**
         * 문제 해결 전략
         *
         * 1. 몬스터의 수가 N/2 >= 1 충족되어야 함
         * 2. 몬스터의 종류가 1번에서 계산한 값 이상이면 1번의 계산 값 반환(몬스터의 종류가 충분),
         * 미만이면(몬스터의 종류는 적다는 뜻이므로) 몬스터의 종류 수 만큼 반환
         * 3.
         *
         * 정리
         * 1. 가져갈 수 있는 몬스터의 수가 충분한지 체크
         * 2. 종류가 충분한지 체크
         */

        int totalMonsterSize = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);

        }

        for (Integer key : map.keySet()) {
            if (map.size() == 1 && map.get(key) == 1) {
                return 0;
            }

            int getMonsters = totalMonsterSize / 2;
            if (map.size() >= getMonsters) {
                return getMonsters;
            } else if (map.size() < getMonsters) {
                return map.size();
            }
        }

        return 0;
    }
}