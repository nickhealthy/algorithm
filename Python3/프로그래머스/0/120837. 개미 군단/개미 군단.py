LEVEL_FIVE = 5
LEVEL_THREE = 3
LEVEL_ONE = 1

def solution(hp):
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
            
    return answer