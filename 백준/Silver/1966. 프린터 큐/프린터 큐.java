import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.valueOf(st.nextToken());
            int M = Integer.valueOf(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                q.offerLast(new int[] {i, Integer.valueOf(st.nextToken())});
            }
            
            int count = 0;
            while (!q.isEmpty()) {
                boolean isMax = true;
                int[] front = q.pollFirst();
                
                // 중요도 확인 및 front가 1순위가 아니라면 다시 뒤로 배치
                Iterator<int[]> iter = q.iterator();
                int temp = 0;
                while (iter.hasNext()) {
                    int[] next = iter.next();
                    if (front[1] < next[1]) {
                        q.offerLast(front);
                        for (int i = 0; i < temp; i++) {
                            q.offerLast(q.pollFirst());
                        }
                        isMax = false;
                        break;
                    }
                    temp++;
                }
                
                if (!isMax) continue;

                // 출력
                count++;
                if (front[0] == M) sb.append(count).append("\n");
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}