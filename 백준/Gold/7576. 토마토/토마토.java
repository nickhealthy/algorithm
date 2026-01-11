import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] arr;
    
    static class Tomatoes {
        int x, y, days;
        
        public Tomatoes(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<Tomatoes> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new Tomatoes(j, i, 0));
                }
            }
        }
        
        System.out.println(bfs(queue));
    }
    
    public static int bfs(Queue<Tomatoes> queue) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxDays = 0;
        
        while (!queue.isEmpty()) {
            Tomatoes curr = queue.poll();
            maxDays = Math.max(maxDays, curr.days);
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx >= 0 && nx < m
                   && ny >= 0 && ny < n
                   && arr[ny][nx] == 0) {
                    arr[ny][nx] = 1;
                    queue.offer(new Tomatoes(nx, ny, curr.days + 1));
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return maxDays;
    }
}