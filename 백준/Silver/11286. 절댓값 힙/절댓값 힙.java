import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        // 우선순위 큐: (절댓값, 원본값) 기준으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            
            // 절댓값이 다르면 절댓값이 작은 순
            if (absA != absB) {
                return absA - absB;
            }
            // 절댓값이 같으면 실제 값이 작은 순 (음수가 먼저)
            return a - b;
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num != 0) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}