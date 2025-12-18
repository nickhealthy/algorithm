import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        int[][] arr = new int[15][15];
        for (int i = 0; i < arr.length; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        
        // 층
        for (int i = 1; i < 15; i++) {
            //호
            for (int j = 2; j < 15; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j]; // 현재 층의 호수 - 1 + 아래 층의 호수
            }
        }
        
        while (T-- > 0) {
            int K = Integer.valueOf(br.readLine());
            int N = Integer.valueOf(br.readLine());
            
            sb.append(arr[K][N]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}