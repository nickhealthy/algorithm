import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> sushiCount = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            sushiCount.put(arr[i], sushiCount.getOrDefault(arr[i], 0) + 1);
        }
        
        // 초기 최댓값 계산
        int maxVariety = sushiCount.size();
        if (!sushiCount.containsKey(coupon)) {
            maxVariety = sushiCount.size() + 1;
        }
        
        for (int i = 1; i < n; i++) {
            // 왼쪽 초밥 제거
            int leftSushi = arr[i - 1];
            sushiCount.put(leftSushi, sushiCount.get(leftSushi) - 1);
            if (sushiCount.get(leftSushi) == 0) {
                sushiCount.remove(leftSushi);
            }
            
            // 오른쪽 초밥 추가
            int rightSushi = arr[(i + k - 1) % n];
            sushiCount.put(rightSushi, sushiCount.getOrDefault(rightSushi, 0) + 1);
            
            // 현재 종류 수 계산
            int currentVariety = sushiCount.size();
            if (!sushiCount.containsKey(coupon)) {
                currentVariety++;
            }
            
            maxVariety = Math.max(maxVariety, currentVariety);
        }

        System.out.println(maxVariety);
    }
}