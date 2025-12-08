import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = br.readLine().split(" ");
        int h = Integer.valueOf(strArr[0]);
        int m = Integer.valueOf(strArr[1]);
        
        if (m >= 45) {
            System.out.printf("%d %d", h, m - 45);            
        } else {
            m = 60 - 45 + m;
            
            if (h == 0) {
                h = 23;
            } else {
                h -= 1;
            }
            System.out.printf("%d %d", h, m);
        }

    }
}