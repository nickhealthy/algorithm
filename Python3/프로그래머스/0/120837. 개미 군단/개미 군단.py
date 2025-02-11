LEVEL_FIVE = 5
LEVEL_THREE = 3
LEVEL_ONE = 1

def solution(hp):
    
    """첫 번째 풀이
    answer = 0
    while hp != 0:
        if hp // LEVEL_FIVE:
            answer += hp // LEVEL_FIVE
            hp %= LEVEL_FIVE
        elif hp // LEVEL_THREE:
            answer += hp // LEVEL_THREE
            hp %= LEVEL_THREE
        else:
            answer += hp // LEVEL_ONE
            hp %= LEVEL_ONE
    """
    
    """다른 사람 풀이"""
    answer = 0
    for num in [5, 3, 1]:
        d, hp = divmod(hp, num)
        answer += d
            
    return answer