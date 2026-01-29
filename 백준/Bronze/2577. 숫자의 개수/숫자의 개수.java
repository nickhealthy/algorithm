import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.valueOf(br.readLine());
        int B = Integer.valueOf(br.readLine());
        int C = Integer.valueOf(br.readLine());
        
        String val = String.valueOf(A * B * C);
        
        int[] counts = new int[10];
        val.chars().forEach(ch -> counts[ch - '0']++);
        
        Arrays.stream(counts).forEach(System.out::println);
        
        br.close();
    }
}