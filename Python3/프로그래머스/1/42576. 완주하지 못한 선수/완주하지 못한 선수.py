def solution(participant, completion):
    d = {}
    for x in participant:
        d[x] = d.get(x, 0) + 1
    
    for x in completion:
        d[x] -= 1
    
    dnf = [k for k, v in d.items() if v > 0]
    
    return dnf[0]




""" 풀이2
from collections import Counter

def solution(participant, completion):
    return ''.join(Counter(participant) - Counter(completion))
"""
    