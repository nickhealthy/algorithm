import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());
        
        long[] arr = new long[k];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            long num = Long.valueOf(br.readLine());
            arr[i] = num;
            max = Math.max(max, num);
        }
        
        long min = 1;
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            
            // 길이가 mid 길이일 때 N개 이상 만들 수 있는지 확인
            if (canMake(arr, mid, n)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean canMake(long[] arr, long length, int n) {
        long result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] / length;
        }
        
        return n <= result;
    }
}