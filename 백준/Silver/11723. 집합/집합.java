import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.valueOf(br.readLine());
        StringTokenizer st;
        int S = 0;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")) S = (1 << 21) - 1;
            else if (str.equals("empty")) S = 0;
            else {
                int num = Integer.valueOf(st.nextToken());
                if (str.equals("add")) S |= (1 << num);
                else if (str.equals("remove")) S &= ~(1 << num);
                else if (str.equals("check")) sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if (str.equals("toggle")) S ^= (1 << num);
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}