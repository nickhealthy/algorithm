import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int k = 1;
        while (k * (k + 1) / 2 < x) {
            k++;
        }
        
        // 이전 k 대각선의 누적합 빼기
        int pos = x - k * (k - 1) / 2;

        int numerator = 0;
        int denominator = 0;
        if (k % 2 == 0) { // 짝수
            denominator = (k + 1) - pos;
            numerator = pos;
        } else { // 홀수
            denominator = pos;
            numerator = (k + 1) - pos;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}