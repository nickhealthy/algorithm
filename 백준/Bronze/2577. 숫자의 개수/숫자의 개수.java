import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.valueOf(br.readLine());
        int B = Integer.valueOf(br.readLine());
        int C = Integer.valueOf(br.readLine());
        
        String val = String.valueOf(A * B * C);
        int[] arr = new int[10];
        for (char ch: val.toCharArray()) {
            arr[ch - '0']++;
        }
        
        for (int v: arr) {
            System.out.println(v);
        }
        
        br.close();
    }
}