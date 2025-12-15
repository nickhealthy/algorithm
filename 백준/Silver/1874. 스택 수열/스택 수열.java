import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        int start = 0;
        int idx = 0;
        
        while (N-- > 0) {
            int value = Integer.valueOf(br.readLine());
            if (start < value) {
                for (int i = start + 1; i <= value; i++) {
                    arr[idx++] = i;
                    sb.append("+").append("\n");
                }
                start = value;
            }
            
            else if (arr[idx - 1] != value) {
                System.out.println("NO");
                return;
            }
            
            idx--;
            sb.append("-").append("\n");
        }
        
        System.out.println(sb);
    }
}