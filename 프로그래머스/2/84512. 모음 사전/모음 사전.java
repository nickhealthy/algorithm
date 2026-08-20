class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int count = 0;

        // 1번째 글자
        for (int i = 0; i < 5; i++) {
            String w1 = "" + vowels[i];
            count++;
            if (w1.equals(word)) return count;

            // 2번째 글자
            for (int j = 0; j < 5; j++) {
                String w2 = w1 + vowels[j];
                count++;
                if (w2.equals(word)) return count;

                // 3번째 글자
                for (int k = 0; k < 5; k++) {
                    String w3 = w2 + vowels[k];
                    count++;
                    if (w3.equals(word)) return count;

                    // 4번째 글자
                    for (int l = 0; l < 5; l++) {
                        String w4 = w3 + vowels[l];
                        count++;
                        if (w4.equals(word)) return count;

                        // 5번째 글자
                        for (int m = 0; m < 5; m++) {
                            String w5 = w4 + vowels[m];
                            count++;
                            if (w5.equals(word)) return count;
                        }
                    }
                }
            }
        }

        return count;
    }
}