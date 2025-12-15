import java.util.*;
import java.io.*;

class Main {
    static int temp = 1;
    static boolean isNotValid = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(br.readLine());
            
            for (; temp <= num; temp++) {
                stack.add(temp);
                sb.append("+\n");
            }
            
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else isNotValid = true;
        }
        
        if (isNotValid) {
            System.out.println("NO");
        } else System.out.println(sb);
    }
}