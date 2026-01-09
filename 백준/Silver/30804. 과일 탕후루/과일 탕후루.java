import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] fruits = new int[n];
        
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.valueOf(input[i]);
        }
        
        
        HashMap<Integer, Integer> fruitsCount = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // 과일 추가
            int fruit = fruits[right];
            fruitsCount.put(fruit, fruitsCount.getOrDefault(fruit, 0) + 1);
            
            // 과일 종류가 2개 이상일 때 left에서 삭제
            while (fruitsCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitsCount.put(leftFruit, fruitsCount.get(leftFruit) - 1);
                
                if (fruitsCount.get(leftFruit) == 0) {
                    fruitsCount.remove(leftFruit);
                }
                
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        
        System.out.println(maxLength);
        
    }
}