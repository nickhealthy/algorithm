import java.io.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        while((str = br.readLine()) != null) {
            int answer = Stream.of(str.split(" ")).mapToInt(e -> Integer.valueOf(e)).sum();
            System.out.println(answer);
        }
    }
}