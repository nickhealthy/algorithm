def solution(age):

    alphabet_dict = {str(i): chr(97 + i) for i in range(26)}

    answer = ''
    for char in str(age):
        answer += alphabet_dict[char]
    
    return answer