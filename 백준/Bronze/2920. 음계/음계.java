import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        
        boolean asc = true;
        boolean dsc = true;
        boolean mixed = true;
        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) dsc = false;
            if (arr[i] > arr[i + 1]) asc = false;
        }
        
        if (asc) System.out.println("ascending");
        else if (dsc) System.out.println("descending");
        else System.out.println("mixed");
    }
}