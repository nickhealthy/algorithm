import java.util.*;

// 1안 - 정확성 o, 효율성 x
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
// class Solution {
//     public boolean solution(String[] phoneBook) {
//         boolean answer = true;
//         Arrays.sort(phoneBook);
        
//         for (int i = 0; i < phoneBook.length - 1; i++) {
//             if (phoneBook[i + 1].startsWith(phoneBook[i])) {
//                 answer = false;
//                 break;
//             }
//         }

//         return answer;

//     }
// }


class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet();
        
        for (String text: phoneBook) {
            set.add(text);
        }
        
        for (String text: phoneBook) {
            for (int i = 1; i < text.length(); i++) {
                if (set.contains(text.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}