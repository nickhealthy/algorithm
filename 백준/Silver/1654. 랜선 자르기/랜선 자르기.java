import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        
        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        
        Arrays.sort(arr);
        long min = 1;
        long max = arr[K - 1];
        
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            
            if (canMake(arr, mid, N)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean canMake(long[] arr, long mid, int n) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] / mid;
        }
        
        return n <= result;
    }
}