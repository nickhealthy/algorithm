import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            int z = Integer.valueOf(st.nextToken());
            
            if (x == 0 && y == 0 && z == 0) break;
            
            if (Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)
               || Math.pow(y, 2) + Math.pow(z, 2) == Math.pow(x, 2)
               || Math.pow(z, 2) + Math.pow(x, 2) == Math.pow(y, 2))
                System.out.println("right");
            else System.out.println("wrong");
        }
    }
}