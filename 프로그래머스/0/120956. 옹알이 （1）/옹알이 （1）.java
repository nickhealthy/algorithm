class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        String[] strArr = {"aya", "ye", "woo", "ma"};

        for(String s: babbling) {
            for (int i = 0; i < strArr.length; i++) {
                s = s.replace(strArr[i], " ");
            }

            if (s.trim().isEmpty()) {
                System.out.printf(s);
                answer++;
            }
        }

        return answer;
    }
}