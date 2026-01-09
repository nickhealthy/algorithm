import java.util.*;
import java.io.*;

class Main {
    static int m, n, h;
    static int[][][] arr;
    
    static class Point {
        int x, y, z, day;
        Point(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        h = Integer.valueOf(st.nextToken());
        
        arr = new int[h][n][m];
        Queue<Point> queue = new LinkedList<>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.valueOf(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.offer(new Point(k, j, i, 0));
                    }
                }
            }
        }
        
        System.out.println(bfs(queue));
        
    }
    
    public static int bfs(Queue<Point> queue) {
        int maxDay = 0;
        
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            maxDay = Math.max(maxDay, curr.day);
            
            for (int i = 0; i < 6; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int nz = curr.z + dz[i];
            
                if (nx >= 0 && nx < m 
                    && ny >= 0 && ny < n 
                    && nz >= 0 && nz < h
                   && arr[nz][ny][nx] == 0) {
                    queue.offer(new Point(nx, ny, nz, curr.day + 1));
                    arr[nz][ny][nx] = 1;
                }
            }
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        
        return maxDay;
    }
}