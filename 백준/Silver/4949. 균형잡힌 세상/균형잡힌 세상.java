import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = "";
        while (!(str = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            // 문자열을 문자 단위로 하나씩 확인
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                
                // 여는 괄호는 스택에 추가
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } 
                // 닫는 괄호 처리
                else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                } 
                else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                // 다른 문자는 무시
            }
            
            // 스택이 비어있고 유효성 검사를 통과해야 yes
            if (isValid && stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        
        bw.close();
        br.close();
    }
}