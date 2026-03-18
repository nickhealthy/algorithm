import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        List<int[]> empty = new ArrayList();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) empty.add(new int[] {i, j});
            }
        }
        
        int size = empty.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    // 벽 세우기
                    graph[empty.get(i)[0]][empty.get(i)[1]] = 1;
                    graph[empty.get(j)[0]][empty.get(j)[1]] = 1;
                    graph[empty.get(k)[0]][empty.get(k)[1]] = 1;
                    
                    result = Math.max(result, bfs());
                   
                    // 복구
                    graph[empty.get(i)[0]][empty.get(i)[1]] = 0;
                    graph[empty.get(j)[0]][empty.get(j)[1]] = 0;
                    graph[empty.get(k)[0]][empty.get(k)[1]] = 0;                    
                }
            }
        }
        
        System.out.println(result);
    }
    
    private static int bfs() {
        int count = 0;        
        Queue<int[]> q = new ArrayDeque();
        int[][] copyGraph = new int[N][M];
        
        // graph 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyGraph[i][j] = graph[i][j];
                if (graph[i][j] == 2) q.add(new int[] {i, j});
            }
        }
        
        // 바이러스 전파
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && copyGraph[nx][ny] == 0) {
                    copyGraph[nx][ny] = 2;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyGraph[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}