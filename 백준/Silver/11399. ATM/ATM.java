import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[1001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.valueOf(st.nextToken())]++;
        }
        
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < 1001; i++) {
            
            while (arr[i]-- > 0) {
                answer += i + prev;
                prev += i;
            }
        }
        
        System.out.println(answer);
        
    }
}