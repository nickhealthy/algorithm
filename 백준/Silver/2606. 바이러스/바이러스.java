import java.io.*;
import java.util.*;

class Main {
    private static final int START_INDEX = 1;
    private static int COMPUTERS;
    private static int N;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        COMPUTERS = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[START_INDEX + COMPUTERS];
        for (int i = START_INDEX; i <= COMPUTERS; i++) {
            graph[i] = new ArrayList();
        }
        
        for (int i = START_INDEX; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            
            graph[to].add(from);
            graph[from].add(to);
        }
        
        System.out.println(bfs(START_INDEX));
    }
    
    private static int bfs(int start) {
        int count = 0;
        visited = new boolean[START_INDEX + COMPUTERS];
        visited[start] = true;
        
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        
        while (!q.isEmpty()) {
            count++;
            int current = q.poll();
            
            for (int next: graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return count - 1;
    }
}