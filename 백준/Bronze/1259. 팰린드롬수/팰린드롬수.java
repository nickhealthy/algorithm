import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "";

        while ((str = br.readLine()) != null) {
            if (str.equals("0")) {
                break;
            }
            
            Stack<Integer> stack = new Stack<>();
            
            Integer[] intArr = Arrays.stream(str.split(""))
                                .map(Integer::valueOf)
                                .toArray(Integer[]::new);
            
            for (int v: intArr) {
                stack.push(v);
            }
            
            boolean isPalindrome = true;
            for (int i = 0; i < intArr.length; i++) {
                if (intArr[i] != stack.pop()) {
                    isPalindrome = false;
                    break;
                }
            }
            
            System.out.println(isPalindrome ? "yes" : "no");
        }
    }
}