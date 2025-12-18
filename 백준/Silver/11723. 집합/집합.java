import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        Set<Integer> set = new HashSet<>();
        while (T-- > 0) {
            String[] strArr = br.readLine().split(" ");
            String command = strArr[0];
            
            int num = 0;
            if (strArr.length > 1) num = Integer.valueOf(strArr[1]);
            
            switch (command) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    if (set.contains(num)) {
                        set.remove(num);
                    }
                    break;
                case "check":
                    if (set.contains(num)) {
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                        break;
                    }
                    set.add(num);
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}