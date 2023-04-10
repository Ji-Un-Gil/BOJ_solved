import sys

n, target = map(int, sys.stdin.readline().split())
frequency = 0
for num in range(1, n+1):
    frequency += str(num).count(str(target))
print(frequency)