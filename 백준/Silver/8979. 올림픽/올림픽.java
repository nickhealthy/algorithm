import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
           if (b[1] != a[1]) return b[1] - a[1];
           else if (b[2] != a[2]) return b[2] - a[2];
           else return b[3] - a[3];
        });
        
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (arr[i][1] != arr[i - 1][1] || arr[i][2] != arr[i - 1][2] || arr[i][3] != arr[i - 1][3]))
                rank = i + 1;
            
            if (arr[i][0] == k) {
                System.out.println(rank);
                return;
            }
        }
        
    }
}