import sys

ulim = list(map(int, sys.stdin.readline().split()))
startlink = list(map(int, sys.stdin.readline().split()))
idx = 0
ulim_score, startlink_score = ulim[0], 0
is_reversal = False
while idx < 8:
    if ulim_score > startlink_score:
        is_reversal = True
        break
    startlink_score += startlink[idx]
    idx += 1
    ulim_score += ulim[idx]

if ulim_score > startlink_score:
    is_reversal = True

if is_reversal:
    print("Yes")
else:
    print("No")