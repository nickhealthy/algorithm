import java.util.*;


/**
0. ) size가 0이면 false
1. ( 일 때만 스택 push
2. ) 일 때만 스택 pop
3. 최종적으로 stack size가 0이면 true
*/
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack();
        
        for (char ch: s.toCharArray()) {
            if (st.isEmpty() && ch == ')') return false;
            else if (ch == '(') st.push(ch);
            else if (ch == ')') st.pop();
            
        }
        
        if (st.isEmpty()) return true;
        else return false;
        
        
    }
}