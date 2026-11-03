import java.util.*;


class Solution {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet();
        
        for (int e: nums) {
            hs.add(e);
        }

        int length = nums.length / 2;
        return Math.min(length, hs.size());
    }
}