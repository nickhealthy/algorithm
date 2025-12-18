import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int answer = 0;
        int temp = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < temp && j < N; j++) {
                answer += arr[j];
            }
            temp++;
        }
        
        System.out.println(answer);
        
    }
}