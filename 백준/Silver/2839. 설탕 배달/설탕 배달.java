import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.valueOf(br.readLine());
        int answer = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            }
            
            if (N < 3) {
                answer = -1;
                break;
            }
            
            N -= 3;
            answer++;
        }
        
        bw.write(answer + "");
        
        bw.close();
        br.close();
    }
}