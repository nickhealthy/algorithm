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
            
            Deque<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.offerLast(new int[] {i, Integer.valueOf(st.nextToken())}); // 순번, 중요도
            }
            
            int count = 0;
            while (!q.isEmpty()) {
                boolean isMax = true;
                int[] front = q.pollFirst();
                
                Iterator<int[]> iter = q.iterator();
                int moveCount = 0;
                while (iter.hasNext()) {
                    int[] next = iter.next();
                    if (front[1] < next[1]) {
                        q.offerLast(front);
                        for (int j = 0; j < moveCount; j++) {
                            q.offerLast(q.pollFirst());
                        }
                        isMax = false;
                        break;
                    }
                    moveCount++;
                }
                
                if (!isMax) continue;
                
                // 여기까지 오면 출력해야 하는 문서
                count++;
                // 찾고 있는 문서가 현재 출력물이라면
                if (front[0] == M) {
                    sb.append(count).append("\n");
                    break;
                }
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}