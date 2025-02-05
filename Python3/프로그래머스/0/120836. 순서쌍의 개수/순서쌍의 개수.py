def solution(n):
    answer = 0
    # 1부터 n까지 확인하면서 n을 나누어 떨어지는 숫자를 찾기
    for i in range(1, n + 1):
        if n % i == 0:
            answer += 1  # (i, n//i)와 (n//i, i) 두 가지 순서쌍이 존재
    return answer
