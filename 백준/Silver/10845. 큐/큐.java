import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        
        int N = Integer.valueOf(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            
            String[] strArr = br.readLine().split(" ");
            switch (strArr[0]) {
                case "push":
                    int num = Integer.valueOf(strArr[1]);
                    q.add(num);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        result.append(-1).append("\n");
                        break;
                    }
                    result.append(q.poll()).append("\n");
                    break;
                case "size":
                    result.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (!q.isEmpty()) {
                        result.append(0).append("\n");
                        break;
                    } 
                    result.append(1).append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        result.append(-1).append("\n");
                        break;
                    }
                    result.append(q.peek()).append("\n");
                    break;
                case "back":
                    if (q.isEmpty()) {
                        result.append(-1).append("\n");
                        break;
                    }
                    result.append(q.getLast()).append("\n");
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(result);
        
        br.close();
    }
}