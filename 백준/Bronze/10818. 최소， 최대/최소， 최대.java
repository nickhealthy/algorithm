import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        Integer[] arr = Stream.of(br.readLine().split(" ")).map(e -> Integer.valueOf(e)).toArray(Integer[]::new);
        
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[n - 1]);
    }
}