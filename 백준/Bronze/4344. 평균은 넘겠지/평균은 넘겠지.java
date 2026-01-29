import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.valueOf(st.nextToken());
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.valueOf(st.nextToken());
            }

            double avg = Arrays.stream(scores).average().orElse(0.0);

            long count = Arrays.stream(scores).filter(s -> s > avg).count();

            double percentage = (count / (double) scores.length) * 100;

            System.out.printf("%.3f%%\n", percentage);
        }
    }
}