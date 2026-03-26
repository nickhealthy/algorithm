import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int minV = Integer.MAX_VALUE;
    static int[][] room;
    static List<int[]> cctvs = new ArrayList<>();
    
    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 타입, 회전, 방향
    static int[][][] dirs = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{3, 0, 1}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
        {{0, 1, 2, 3}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] != 0 && room[i][j] != 6) {
                    cctvs.add(new int[] {i, j, room[i][j]}); // row, col, cctv_type
                }
            }
        }
        
        simulate(0, room);
        System.out.println(minV);
        
    }
    
    private static void simulate(int depth, int[][] room) {
        if (depth == cctvs.size()) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (room[i][j] == 0) {
                        result++;
                    }
                }
            }
            
            minV = Math.min(minV, result);
            return;
        }
        
        int[] cctv = cctvs.get(depth);
        int type = cctv[2];
        
        // 각 CCTV 마다 방향 감시
        for (int rot = 0; rot < dirs[type].length; rot++) {
            int[][] copy = new int[n][m];
            // 배열 복사
            for (int row = 0; row < n; row++) {
                System.arraycopy(room[row], 0, copy[row], 0, m);
            }
            
            // CCTV가 바라본 방향으로 룸 방문 체크
            for (int d: dirs[type][rot]) {
                int x = cctv[0];
                int y = cctv[1];
                
                while (true) {
                    x += dx[d];
                    y += dy[d];
                    
                    if (!isInBounds(x, y)) break;
                    if (copy[x][y] == 6) break; // 벽 만나면 pass
                    copy[x][y] = -1; // 방문 처리
                }
            }
            
            simulate(depth + 1, copy);
        }
    }
    
    private static boolean isInBounds(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}