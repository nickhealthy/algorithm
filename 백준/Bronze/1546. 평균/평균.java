import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        double[] score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextDouble();
        }
        
        Arrays.sort(score);
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += score[i] / score[score.length - 1] * 100;
        }
        
        System.out.print(sum / N);
    }
}