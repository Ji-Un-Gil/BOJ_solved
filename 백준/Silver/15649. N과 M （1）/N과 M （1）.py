import sys
from itertools import permutations

N, M = map(int, sys.stdin.readline().split())

ans = list(permutations(range(1, N+1), M))
for item in ans:
    print(' '.join(list(map(str, item))))