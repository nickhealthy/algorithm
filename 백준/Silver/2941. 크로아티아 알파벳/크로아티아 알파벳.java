import java.io.*;
import java.util.*;

class Main {
    static final String[] CROATIA = {
      "dz=", "z=", "c=", "c-", "d-", "s=", "lj", "nj"  
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        System.out.println(countWords(input));
        
    }
    
    private static int countWords(String input) {
        for (String word: CROATIA) {
            input = input.replace(word, "*");
        }
        
        return input.length();
    }
}