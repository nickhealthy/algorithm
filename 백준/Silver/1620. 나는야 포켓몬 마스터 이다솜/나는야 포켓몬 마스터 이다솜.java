import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        Map<String, String> mapNumber = new HashMap<>();
        Map<String, String> mapLetter = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            mapNumber.put(String.valueOf(i), input);
            mapLetter.put(input, String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (isNumber(target)) {
                sb.append(mapNumber.get(target)).append("\n");
            } else {
                sb.append(mapLetter.get(target)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}