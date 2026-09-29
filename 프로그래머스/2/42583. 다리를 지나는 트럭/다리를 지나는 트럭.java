import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque(Collections.nCopies(bridge_length, 0));
        
        
        int time = 0;
        int pos = 0;
        int currWeight = 0;
        
        int n = truck_weights.length;
        while (pos < n) {
            time++;
            
            currWeight -= bridge.poll();
            
            if (currWeight + truck_weights[pos] <= weight) {
                currWeight += truck_weights[pos];
                bridge.add(truck_weights[pos++]);
            } else {
                bridge.add(0);
            }
        }
        
        time += bridge_length;
    
        return time;
    }
}