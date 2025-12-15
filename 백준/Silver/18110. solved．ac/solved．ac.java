import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        
        Arrays.sort(arr);
        int except = (int) Math.round(N * 0.15);
        
        int sum = 0;
        for (int i = except; i < N - except; i++) {
            sum += arr[i];
        }
        
        System.out.println(Math.round((float) sum / (N - (except * 2))));
    }
}