import java.io.*;
import java.util.*;

class Main {
    
    private static List<Integer>[] board;
    private static boolean[] visited;
    private static int n, m, v;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        board = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            board[i] = new ArrayList();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            
            board[to].add(from);
            board[from].add(to);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(board[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        
        visited = new boolean[n + 1];
        bfs(v);
        
        System.out.println(sb.toString());
    }
    
    private static void dfs(int current) {
        visited[current] = true;
        sb.append(current).append(" ");
        
        for (int next: board[current]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            
            for (int next: board[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}