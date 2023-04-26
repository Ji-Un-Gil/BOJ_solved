import sys


def josephus(lst, idx, k):
    count = 0
    while count < k - 1:
        if idx == len(lst):
            idx = 0
        idx += 1
        count += 1
    if idx == len(lst):
        idx = 0
    return idx


def get_result(n, k):
    result = "<"
    circle = [i+1 for i in range(n)]
    idx = 0
    while len(circle) > 1:
        idx = josephus(circle, idx, k)
        result += str(circle[idx]) + ", "
        del circle[idx]
    result += str(circle[0]) + ">"
    return result


N, K = map(int, sys.stdin.readline().split())
print(get_result(N, K))