import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] grid, colorBlindGrid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());

        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int normalCount = countRegions(grid);

        colorBlindGrid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    colorBlindGrid[i][j] = 'R';
                } else {
                    colorBlindGrid[i][j] = grid[i][j];
                }
            }
        }

        int colorBlindCount = countRegions(colorBlindGrid);
        System.out.println(normalCount + " " + colorBlindCount);
    }

    private static int countRegions(char[][] targetGrid) {
        visited = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, targetGrid[i][j], targetGrid);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, char color, char[][] targetGrid) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && targetGrid[nx][ny] == color
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }

        }
    }
}