import java.io.*;
import java.util.*;

class Main {
    
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static final int REQUIRED_WALL = 3;
    private static final int[][] DIRECTIONS = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    private static int n, m, answer;
    private static int[][] graph;
    private static List<Point> emptySpaces = new ArrayList();
    private static List<Point> virusSpaces = new ArrayList();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                int value = Integer.parseInt(st.nextToken());
                graph[row][col] = value;
                
                if (value == EMPTY) {
                    emptySpaces.add(Point.of(row, col));
                } else if (value == VIRUS) {
                    virusSpaces.add(Point.of(row, col));
                }
            }
        }
        
        buildWalls(0, 0);
        System.out.println(answer);
        
    }
    
    private static void buildWalls(int startIndex, int selectedCount) {
        if (selectedCount == REQUIRED_WALL) {
            answer = Math.max(answer, simulateVirusSpread());
            return;
        }
        
        for (int index = startIndex; index < emptySpaces.size(); index++) {
            Point wall = emptySpaces.get(index);
            graph[wall.row][wall.col] = WALL;
            buildWalls(index + 1, selectedCount + 1);
            graph[wall.row][wall.col] = EMPTY;
        }
    }
    
    private static int simulateVirusSpread() {
        int[][] copiedGraph = copyGraph();
        Queue<Point> queue = new ArrayDeque(virusSpaces);
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            
            for (int[] direction: DIRECTIONS) {
                int nextRow = curr.row + direction[0];
                int nextCol = curr.col + direction[1];
                
                if (isOutOfRange(nextRow, nextCol)) {
                    continue;
                }
                if (copiedGraph[nextRow][nextCol] != EMPTY) {
                    continue;
                }
                
                copiedGraph[nextRow][nextCol] = VIRUS;
                queue.offer(Point.of(nextRow, nextCol));
            }
        }
        
        return countSafeArea(copiedGraph);
    }
    
    private static int[][] copyGraph() {
        int[][] copied = new int[n][m];
        for (int row = 0; row < n; row++) {
            System.arraycopy(graph[row], 0, copied[row], 0, m);
        }
        
        return copied;
    }
    
    private static int countSafeArea(int[][] copiedGraph) {
        int safeArea = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (copiedGraph[row][col] == EMPTY) {
                    safeArea++;
                }
            }
        }
        
        return safeArea;
    }
    
    private static boolean isOutOfRange(int row, int col) {
        return row < 0 || row >= n || col < 0 || col >= m;
    }
    
    private static class Point {
        private final int row;
        private final int col;
        
        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        private static Point of(int row, int col) {
            return new Point(row, col);
        }
    }
}