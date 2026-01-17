import java.io.*;
import java.util.*;

public class Main {

    static int[] dist;
    static List<Integer>[] board;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        board = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start].add(end);
        }


        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        bfs(X);

        boolean found = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("-1");
        } else {
            System.out.println(sb);
        }


    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : board[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

    }
}