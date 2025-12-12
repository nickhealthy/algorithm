import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.valueOf(br.readLine());
        // 나이 범위: 1 ~ 200
        StringBuilder[] p = new StringBuilder[201]; // 선언
        for (int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder(); // 초기화
        }
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.valueOf(st.nextToken());
            String name = st.nextToken();
            
            p[age].append(age).append(' ').append(name).append("\n");
        }
        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder val: p) {
            sb.append(val);
        }
        
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}