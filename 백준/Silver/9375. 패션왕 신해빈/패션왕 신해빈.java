import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            
            int N = Integer.valueOf(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }
            
            int result = 1;
            
            for(int val: map.values()) {
                result *= (val + 1);
            }
            
            sb.append(result - 1).append("\n");
        }
        
        System.out.println(sb);
    }
}