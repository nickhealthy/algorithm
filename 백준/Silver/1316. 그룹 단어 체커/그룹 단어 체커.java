import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isRight(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private static boolean isRight(String input) {
        boolean[] alphabet = new boolean[26];
        char prev = input.charAt(0);
        
        for (char c: input.toCharArray()) {
            if (prev != c) {
                if (alphabet[c - 'a']) return false;
            }
            
            alphabet[c - 'a'] = true;
            prev = c;
        }
        
        return true;
    }
}