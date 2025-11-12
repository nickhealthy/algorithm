import java.util.*;

class Solution {

    public long solution(long n) {
        /**
        char[] charArr = String.valueOf(n).toCharArray();
        Arrays.sort(charArr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            sb.append(charArr[i]);
        }
        
        
        return Long.valueOf(sb.toString());
        */
        
        // 2번째 풀이
        Stack<Character> stack = new Stack<>();
        String.valueOf(n).chars().sorted().forEach(c -> stack.push(Character.valueOf((char)c)));
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        
        return Long.valueOf(sb.toString());
        
    }
}