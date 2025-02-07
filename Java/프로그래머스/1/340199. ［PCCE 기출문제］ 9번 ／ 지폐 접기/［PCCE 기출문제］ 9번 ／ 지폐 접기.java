class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (min(wallet) < min(bill) || max(wallet) < max(bill)) {
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }
        
        return answer;
    }
    
    private int max(int[] size) {
        return Math.max(size[0], size[1]);
    }
    
    private int min(int[] size) {
        return Math.min(size[0], size[1]);
    }
}