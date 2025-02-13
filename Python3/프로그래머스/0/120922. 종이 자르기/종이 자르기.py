def solution(M, N):
    if M == 1 and N == 1:
        return 0
    
    if M > 1:
        return (M - 1) + (M * (N - 1))
    
    return (M - 1) + (N - 1)