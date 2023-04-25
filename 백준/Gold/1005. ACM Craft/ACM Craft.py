import sys


def cal_time(target, pre_model, acc_time, time, is_visited):
    if is_visited[target]:
        return
    for k in pre_model[target]:
        cal_time(k, pre_model, acc_time, time, is_visited)
        if acc_time[k] > acc_time[target]:
            acc_time[target] = acc_time[k]
    acc_time[target] += time[target]
    is_visited[target] = True


def solution():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    time = list(map(int, sys.stdin.readline().rstrip().split()))
    acc_time = [0 for n in range(N)]
    is_visited = [False for n in range(N)]
    pre_model = {}
    for i in range(N):
        pre_model[i] = []

    while K > 0:
        X, Y = map(int, sys.stdin.readline().rstrip().split())
        pre_model[Y - 1].append(X - 1)
        K -= 1

    target = int(sys.stdin.readline())
    cal_time(target - 1, pre_model, acc_time, time, is_visited)

    return acc_time[target - 1]


T = int(sys.stdin.readline())
while T > 0:
    print(solution())
    T -= 1
