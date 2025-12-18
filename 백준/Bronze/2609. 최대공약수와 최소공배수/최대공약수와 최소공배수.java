import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.valueOf(st.nextToken());
        int num2 = Integer.valueOf(st.nextToken());
        
        System.out.println(gcd(num1, num2));
        System.out.println(num1 * num2 / gcd(num1, num2));
    }
    
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}