import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(meetings, (a, b) -> {
           return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]; 
        });
        
        int count = 0;
        int end = 0;
        for (int[] m: meetings) {
            if (m[0] >= end) {
                count++;
                end = m[1];
            }
        }
        
        System.out.println(count);
        
    }
}