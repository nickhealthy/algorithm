import java.util.*;

class Solution {
    public String solution(String my_string) {
        final int LENGTH = my_string.length();
        
        char[] chrArr = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            char c = my_string.charAt(i);
            int tmp = (int) c;
            
            if (tmp >= 65 && tmp <= 90) {
                tmp += 32;
            } else {
                tmp -= 32;
            }
            chrArr[i] = (char) tmp;
        }
        
        return new String(chrArr);
    }
}