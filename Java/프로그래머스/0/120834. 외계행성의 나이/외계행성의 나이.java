import java.util.*;

class Solution {
    public String solution(int age) {

        Map<Integer, Character> alphabetMap = new HashMap();

        for (int i = 0; i < 26; i++) {
            alphabetMap.put(i, (char) (97 + i));
        }

        String stringAge = String.valueOf(age);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringAge.length(); i++) {
            Character c = alphabetMap.get(Integer.valueOf(String.valueOf(stringAge.charAt(i))));
            sb.append(c);
        }

        return sb.toString();
    }
}