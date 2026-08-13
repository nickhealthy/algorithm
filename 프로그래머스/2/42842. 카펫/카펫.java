/**
 1. 전체 격자수: brown + yello
 2. 가로/세로 길이 관계: 가로는 세로보다 같거나 길고, 노란색이 중앙에 존재하려면 세로 길이는 최소 3이상
 3. 노란색 격자의 크기 조건:
   yello는 brown에 상하좌우 테두리 1줄로 둘러싸여 있으므로
   노란색 가로: width - 2
   노란색 세로: height - 2
   노란색: (width - 2) * (height - 2) == yello
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;
                
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }
            }
        }
        
        return new int[] {};
    }
}