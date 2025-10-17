import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String s) throws IOException {
        boolean answer = true;
        int length = s.length();
        
        if (length != 4 && length != 6) return false;
        
        for (char c: s.toCharArray()) {
            int numeric = Character.getNumericValue(c);
            numeric += 48;
            
            if (numeric < 48 || numeric > 57) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}