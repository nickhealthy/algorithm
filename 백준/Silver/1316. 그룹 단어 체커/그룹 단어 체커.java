import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isGroupWord(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private static boolean isGroupWord(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char prev = input.charAt(0);
        
        for (char c: input.toCharArray()) {
            if (prev != c) {
                if (map.containsKey(c)) return false;
            }

            map.put(c, map.getOrDefault(map.get(c), 0) + 1);
            prev = c;
        }
        
        return true;
        
    }
}