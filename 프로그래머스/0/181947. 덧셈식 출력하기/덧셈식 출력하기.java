import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        
        
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();

        System.out.printf("%d + %d = %d", a, b, a + b);
    }
}