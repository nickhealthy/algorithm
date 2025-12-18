import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }
        sb.append(list.size()).append("\n");
        
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        
        System.out.println(sb);
        br.close();
        
    }
}