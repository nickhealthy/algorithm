def solution(age):

    """첫 번째 풀이
    alphabet_dict = {str(i): chr(97 + i) for i in range(26)}

    answer = ''
    for char in str(age):
        answer += alphabet_dict[char]
    """
    
    """다른 사람 풀이"""
    return "".join([chr(int(char) + 97) for char in str(age)])
    
