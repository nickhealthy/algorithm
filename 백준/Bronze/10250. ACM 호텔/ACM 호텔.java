import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int T = Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            int answer = 001;
           
            String[] strArr = br.readLine().split(" ");
            Integer[] input = Stream.of(strArr)
                                .map(e -> Integer.valueOf(e))
                                .toArray(Integer[]::new);
            
            int h = input[0];
            int w = input[1];
            int n = input[2];
            
            if (n % h == 0) {
                System.out.println((h * 100) + (n / h));
            } else {
                System.out.println((n % h) * 100 + (n / h) + 1);
            }
        }
    }
}