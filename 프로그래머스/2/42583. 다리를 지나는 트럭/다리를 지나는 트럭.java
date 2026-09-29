// import java.util.*;

// class Solution {
//     public int solution(int bridge_length, int weight, int[] truck_weights) {
//         Deque<Integer> bridge = new ArrayDeque(Collections.nCopies(bridge_length, 0));
        
        
//         int time = 0;
//         int pos = 0;
//         int currWeight = 0;
        
//         int n = truck_weights.length;
//         while (pos < n) {
//             time++;
            
//             currWeight -= bridge.poll();
            
//             if (currWeight + truck_weights[pos] <= weight) {
//                 currWeight += truck_weights[pos];
//                 bridge.add(truck_weights[pos++]);
//             } else {
//                 bridge.add(0);
//             }
//         }
        
//         time += bridge_length;
    
//         return time;
//     }
// }

import java.util.*;


class Solution {
    class Truck {
        int move;
        int weight;
        
        Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }
        
        void moving() {
            this.move++;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList();
        Queue<Truck> moveQ = new LinkedList();
        
        for (int w: truck_weights) {
            waitQ.offer(new Truck(w));
        }
        
        int time = 0;
        int currWeight = 0;
        
        while (!moveQ.isEmpty() || !waitQ.isEmpty()) {
            time++;
            
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                currWeight += t.weight;
                moveQ.offer(t);
                continue;
            }
            
            for (Truck t: moveQ) {
                t.moving();
            }
            
            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                currWeight -= t.weight;
            }
            
            if (!waitQ.isEmpty() && currWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                currWeight += t.weight;
                moveQ.offer(t);
            }
        }
        
        
        return time;
    }
}