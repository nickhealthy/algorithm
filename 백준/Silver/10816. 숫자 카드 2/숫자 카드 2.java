import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        int N = Integer.valueOf(br.readLine());
        String[] strArr = br.readLine().split(" ");
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = Integer.valueOf(strArr[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int M = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int token = Integer.valueOf(st.nextToken());
            
            if (map.containsKey(token)) {
                result.append(map.get(token)).append(" ");
            } else {
                result.append(0).append(" ");
            }
        }
        
        System.out.println(result);
        
    }
}