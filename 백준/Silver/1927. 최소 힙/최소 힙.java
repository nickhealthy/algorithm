import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.valueOf(br.readLine());
        while (N-- > 0) {
            int num = Integer.valueOf(br.readLine());
            
            if (num == 0) {
                if (q.isEmpty()) sb.append(0).append("\n");
                else sb.append(q.poll()).append("\n");
            } else {
                q.offer(num);
            }
        }
        
        System.out.println(sb);
        
    }
}