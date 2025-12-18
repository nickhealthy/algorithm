import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            
            map.put(site, password);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String answer = map.get(st.nextToken());
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}