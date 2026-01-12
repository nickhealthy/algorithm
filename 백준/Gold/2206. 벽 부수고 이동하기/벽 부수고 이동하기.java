import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;

    static class Temp {
        int x, y, count, wall;

        public Temp(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = charArray[j] - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        visited[0][0][0] = true;
        Queue<Temp> queue = new LinkedList<>();
        queue.offer(new Temp(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            Temp curr = queue.poll();

            if (curr.x == n - 1 && curr.y == m - 1) {
                return curr.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 빈칸인 경우
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][curr.wall]) {
                            visited[nx][ny][curr.wall] = true;
                            queue.offer(new Temp(nx, ny, curr.count + 1, curr.wall));
                        }
                        // 벽인 경우
                    } else if (map[nx][ny] == 1 && curr.wall == 0) {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.offer(new Temp(nx, ny, curr.count + 1, 1));
                        }

                    }
                }
            }
        }

        return -1;
    }

}