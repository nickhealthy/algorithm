import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        // 만료 시간 관리 (만료 시간, 서버 수)
        PriorityQueue<int[]> expiringServers = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int activeServers = 0;  // 현재 운영 중인 서버 수
        int totalDeployments = 0;  // 총 증설 횟수

        for (int hour = 0; hour < 24; hour++) {
            // 현재 시간에 만료되는 서버 처리
            while (!expiringServers.isEmpty() && expiringServers.peek()[0] == hour) {
                activeServers -= expiringServers.poll()[1];
            }

            // 현재 시간에 필요한 서버 수 계산
            int neededServers = players[hour] / m;

            // 추가로 필요한 서버 수 계산
            int additionalServers = Math.max(0, neededServers - activeServers);

            // 서버 증설이 필요한 경우
            if (additionalServers > 0) {
                totalDeployments += additionalServers;
                activeServers += additionalServers;

                // 증설한 서버의 만료 시간 기록 (현재 시간 + k)
                expiringServers.add(new int[]{hour + k, additionalServers});
            }
        }

        return totalDeployments;
    }
}

