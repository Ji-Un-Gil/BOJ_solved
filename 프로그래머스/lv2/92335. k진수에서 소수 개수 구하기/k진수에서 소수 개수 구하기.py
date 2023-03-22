import math

def is_prime_number(x):
    if x == 1:
        return False
    # 2부터 x의 제곱근까지의 모든 수를 확인
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def notation_change(n, k):
    # 10진수 -> k진수 변환
    rev_base = ''
    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)
    return rev_base[::-1]

def solution(n, k):
    answer = 0
    k_num = notation_change(n, k)

    # 0 기준으로 수 분할, 이 때 연속된 0이 있을 경우 리스트에 빈 문자열 발생하는 예외까지 처리
    candidate = list(filter(None, k_num.split('0')))
    for num in candidate:
        if is_prime_number(int(num)):
            answer += 1

    return answer
