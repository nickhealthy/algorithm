import java.io.*;
import java.util.*;

class Main {
    
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        graph = new int[n][n];
        int maxH = 0;
        
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                graph[row][col] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, graph[row][col]);
            }
        }
        
        int result = 1;
        for (int h = 1; h < maxH; h++) {
            int count = 0;
            visited = new boolean[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && graph[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            
            result = Math.max(result, count);
        }
        
        System.out.println(result);
    }
    
    static void bfs(int x, int y, int high) {
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction: directions) {
                int nx = direction[0] + curr[0];
                int ny = direction[1] + curr[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                
                if (visited[nx][ny] || graph[nx][ny] <= high) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
   
}