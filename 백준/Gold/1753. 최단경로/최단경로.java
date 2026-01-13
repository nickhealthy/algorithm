import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // 그래프 초기화
        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        int[] dist = dijkstra(graph, V, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

    static int[] dijkstra (List<Edge>[] graph, int V, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currVertex = curr.vertex;
            int currDistance = curr.distance;

            // 이미 처리된 정점 스킵
            if (currDistance > dist[currVertex]) continue;

            // 현재 정점과 연결된 모든 간선 탐색
            for (Edge edge : graph[currVertex]) {
                int nextVertex = edge.to;
                int nextDistance = currDistance + edge.weight;

                // 더 짧은 경로를 발견하면 업데이트
                if (nextDistance < dist[nextVertex]) {
                    dist[nextVertex] = nextDistance;
                    pq.offer(new Node(nextVertex, nextDistance));
                }
            }
        }

        return dist;
    }
}