import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.valueOf(st.nextToken());
            int target = Integer.valueOf(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                // 순서, 중요도
                q.offer(new int[] {i, Integer.valueOf(st.nextToken())});
            }
            
            int count = 0;
            while (!q.isEmpty()) {
                int[] front = q.poll(); // 첫 번째 원소
                boolean isMax = true; // 현재 원소 중요도 체크
                
                for (int i = 0; i < q.size(); i++) {
                    // 현재 프린터 중요도 보다 뒤에 원소가 크다면, 현재 원소 + i 전까지 원소 뒤로 보내기
                    if (front[1] < q.get(i)[1]) {
                        q.offer(front);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                
                if (!isMax) continue;
                
                // 현재 원소(front)가 제일 크다면 출력해야 하는 문서
                count++;
                if (front[0] == target) { // 해당 테스트 케이스에서 원하는 문서 찾았으므로 break
                    sb.append(count).append("\n");
                    break;
                }   
            }
        }
        System.out.println(sb);
        br.close();
    }
}