import java.util.*;
import java.io.*;

class Main {
    static final int[][] DIRECTIONS = {
        {0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}
    };
    
    static int W, H;
    static int[][] graph;
    static boolean[][] visited;
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) throws IOException {
          br = new BufferedReader(new InputStreamReader(System.in));

          while (true) {
              st = new StringTokenizer(br.readLine());
              W = Integer.parseInt(st.nextToken());
              H = Integer.parseInt(st.nextToken());

              if (W == 0 && H == 0) break;

              graph = new int[H][W];
              visited = new boolean[H][W];
              for (int i = 0; i < H; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < W; j++) {
                      graph[i][j] = Integer.parseInt(st.nextToken());
                  }
              }

              int result = 0;
              for (int i = 0; i < H; i++) {
                  for (int j = 0; j < W; j++) {
                      if (graph[i][j] == 1 && !visited[i][j]) {
                          visited[i][j] = true;
                          bfs(i, j);
                          result++;
                      }
                  }
              }
              sb.append(result).append("\n");
          }
          System.out.print(sb);
      }


    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {startR, startC});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : DIRECTIONS) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                if (isInBounds(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
    
    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}