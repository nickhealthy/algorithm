import java.io.*;
import java.util.*;

class Main {
    static final int N = 10;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[42];
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(br.readLine());
            arr[num % 42] = 1;
        }
        
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}