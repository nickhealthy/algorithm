import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        
        if (n == 1) {
            System.out.println(1);
        } else {
            int range = 2;
            while (range <= n) {
                range = range + (6 * answer);
                answer++;
            }
            System.out.println(answer);
        }
    }
}