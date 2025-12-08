import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = br.readLine().split(" ");
        int sum = Stream.of(strArr).mapToInt(e -> {
            int a = Integer.valueOf(e);
            return a *= a;
        }).sum();
        
        System.out.println(sum % 10);
    }
}