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
        char[] chars = input.toCharArray();
        
        map.put(chars[0], 1);
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (map.containsKey(chars[i])) return false;
            }

            map.put(chars[i], 1);
        }
        
        return true;
        
    }
}