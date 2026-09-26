import java.util.*;
import java.util.stream.*;

class Solution {    
    public int[] solution(int[] prices) {
        int n = prices.length;
        ArrayList<Integer> answer = new ArrayList(Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack();
        
        for (int i = 0; i < n; i++) {
            while (!st.empty() && prices[st.peek()] > prices[i]) {
                int index = st.pop();
                answer.set(index, i - index);
            }
            
            st.push(i);
        }
        
        while (!st.empty()) {
            int index = st.pop();
            answer.set(index, (n - 1) - index);
        }
        
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}