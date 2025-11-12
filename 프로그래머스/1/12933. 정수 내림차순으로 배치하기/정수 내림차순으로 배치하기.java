import java.util.*;

class Solution {
    public long solution(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        Arrays.sort(charArr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            sb.append(charArr[i]);
        }
        
        
        return Long.valueOf(sb.toString());
    }
}