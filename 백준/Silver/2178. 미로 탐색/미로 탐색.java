import java.io.*;
import java.util.*;

class Main {
    private static boolean[][] visited;
    private static int[][] graph;
    private static int N, M;

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static final int START_DISTANCE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        visited[0][0] = true;
        queue.offer(new int[] {0, 0, START_DISTANCE});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, distance + 1});
            }
        }

        return -1;
    }
}
