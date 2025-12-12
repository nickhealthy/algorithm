import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        int[][] arr = new int[T][2];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.valueOf(st.nextToken());
            arr[i][1] = Integer.valueOf(st.nextToken());            
        }
        
        for (int i = 0; i < T; i++) {
            int rank = 1;
            
            for (int j = 0; j < T; j++) {
                if (i == j) continue;
                
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            
            sb.append(rank).append(" ");
        }
        
        System.out.print(sb.toString());
    }
}