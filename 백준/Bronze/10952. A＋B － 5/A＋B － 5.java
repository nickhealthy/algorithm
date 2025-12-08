import java.io.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        while((str = br.readLine()) != null) {
            int sum = Stream.of(str.split(" ")).mapToInt(e -> Integer.valueOf(e)).sum();
            if (sum != 0) System.out.println(sum);
        }
    }
}