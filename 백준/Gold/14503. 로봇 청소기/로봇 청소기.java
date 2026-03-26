import java.util.*;
import java.io.*;

class Main {
    static final int[][] DIRECTIONS = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    
    static int N, M, startR, startC, startD;
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        startD = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                graph[row][col] = Integer.parseInt(st.nextToken());
                if (graph[row][col] == 1) visited[row][col] = true;
            }
        }
        
        System.out.println(simulate(startR, startC, startD));
        
    }
    
    private static int simulate(int r, int c, int d) {
        int result = 0;
        
        while (true) {
            if (!visited[r][c]) {
                result++;
                visited[r][c] = true;
            }
            
            if (hasUncleanedAround(r, c)) {
                d = (d + 3) % 4;
                int nr = r + DIRECTIONS[d][0];
                int nc = c + DIRECTIONS[d][1];
                
                if (isInBounds(nr, nc) && !visited[nr][nc]) {
                    r = nr;
                    c = nc;
                }
                
            } else {
                int backD = (d + 2) % 4;
                int nr = r + DIRECTIONS[backD][0];
                int nc = c + DIRECTIONS[backD][1];
                
                if (!isInBounds(nr, nc) || graph[nr][nc] == 1) break;
                
                r = nr;
                c = nc;
            }
        }
        
        return result;
    }
    
    private static boolean hasUncleanedAround(int r, int c) {
        for(int[] dir: DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if (isInBounds(nr, nc) && !visited[nr][nc]) return true;
        }
        
        return false;
    }
    
    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}