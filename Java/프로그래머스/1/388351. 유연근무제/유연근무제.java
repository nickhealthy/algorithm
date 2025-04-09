class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length; // 직원 수
        int rewardCount = 0; // 상품을 받을 직원 수

        for (int i = 0; i < n; i++) {
            // 현재 직원의 출근 희망 시각과 출근 인정 시각 계산
            int desiredTime = schedules[i];
            int acceptableTime = addMinutes(desiredTime, 10);

            boolean isEligible = true; // 현재 직원이 상품을 받을 자격이 있는지

            // 일주일간의 출근 기록 확인
            for (int day = 0; day < 7; day++) {
                // 현재 날짜의 요일 계산 (1: 월, 2: 화, ..., 7: 일)
                int currentDay = (startday + day - 1) % 7 + 1;

                // 주말(토, 일)인 경우 건너뜀
                if (currentDay == 6 || currentDay == 7) continue;

                // 평일인 경우, 출근 인정 시각 내에 출근했는지 확인
                int actualTime = timelogs[i][day];

                if (actualTime > acceptableTime) {
                    isEligible = false;
                    break; // 한 번이라도 늦었으면 더 이상 확인할 필요 없음
                }
            }

            // 모든 평일에 늦지 않고 출근했으면 상품을 받음
            if (isEligible) {
                rewardCount++;
            }
        }

        return rewardCount;
    }

    // 시각에 분을 더하는 헬퍼 함수
    private int addMinutes(int time, int minutes) {
        int hour = time / 100;
        int minute = time % 100;

        minute += minutes;
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }

        return hour * 100 + minute;
    }
}