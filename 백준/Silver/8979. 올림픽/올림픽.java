import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            arr[country][0] = Integer.parseInt(st.nextToken());
            arr[country][1] = Integer.parseInt(st.nextToken());
            arr[country][2] = Integer.parseInt(st.nextToken());
        }
        
        int rank = 1;
        for (int i = 1; i < n; i++) {
            if (i == k) continue;
            if (isBetter(arr[i], arr[k])) rank++;
        }
        
        System.out.println(rank);
        
    }
    
    private static boolean isBetter(int[] a, int[] b) {
        if (a[0] != b[0]) return a[0] > b[0];
        if (a[1] != b[1]) return a[1] > b[1];
        return a[2] > b[2];
    }
}