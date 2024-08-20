import java.util.*;

// 1안
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;

//         Map<Integer, String> map = new HashMap<>();

//         for (int i = 0; i < phone_book.length; i++) {
//             map.put(i ,phone_book[i]);
//         }

//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = 0; j < phone_book[i].length(); j++) {
//                 if (map.containsValue(phone_book[i].substring(0, j))) {
//                     answer = false;
//                 }
//             }
//         }

//         return answer;

//     }
// }

// 2안
class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        Arrays.sort(phoneBook);
        
        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                answer = false;
                break;
            }
        }

        return answer;

    }
}

// 3안
// class Solution {
//     public boolean solution(String[] phoneBook) {
//         String text = String.join(" ", phoneBook);
//         return !Arrays.stream(phoneBook).anyMatch(s -> text.split(s).length > 2);
        
//     }
// }