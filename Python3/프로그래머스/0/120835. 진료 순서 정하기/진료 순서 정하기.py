def solution(emergency):
    answer = []
    
    """첫 번째 풀이 - 기본 for문 사용
    for i in range(len(emergency)):
        count = 0
        for j in range(len(emergency)):
            if emergency[i] < emergency[j]:
                count += 1
        
        answer.append(count + 1)
    """
    
    """두 번째 풀이 - 파이썬닉하게 풀이
    """    
    desending_list = sorted(emergency, reverse=True)
    return [desending_list.index(e) + 1 for e in emergency]
    