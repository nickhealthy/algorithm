import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        
        int[] g = new int[N + 1];
        int[] h = new int[N + 1];
        
        g[1] = 0;
        h[1] = arr[1];
        
        for (int i = 2; i <= N; i++) {
            g[i] = h[i - 1] + arr[i];
            h[i] = Math.max(g[i - 2], h[i - 2]) + arr[i];
        }
        
        System.out.println(Math.max(g[g.length - 1], h[h.length - 1]));
        
    }
}