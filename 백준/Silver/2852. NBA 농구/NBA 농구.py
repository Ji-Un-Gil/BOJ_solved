import sys

first_score, second_score = 0, 0
first_win_min, first_win_sec = 0, 0
second_win_min, second_win_sec = 0, 0
winning_time = "00:00"
N = int(sys.stdin.readline())

while N > 0:
    team, time = sys.stdin.readline().rstrip().split()
    if first_score > second_score:
        first_win_min += int(time[:2]) - int(winning_time[:2])
        first_win_sec += int(time[3:]) - int(winning_time[3:])
        if first_win_sec > 59:
            first_win_sec -= 60
            first_win_min += 1
        elif first_win_sec < 0:
            first_win_sec += 60
            first_win_min -= 1
    elif second_score > first_score:
        second_win_min += int(time[:2]) - int(winning_time[:2])
        second_win_sec += int(time[3:]) - int(winning_time[3:])
        if second_win_sec > 59:
            second_win_sec -= 60
            second_win_min += 1
        elif second_win_sec < 0:
            second_win_sec += 60
            second_win_min -= 1

    if team == "1":
        first_score += 1
    else:
        second_score += 1

    winning_time = time

    N -= 1

if first_score > second_score:
    first_win_min += 48 - int(winning_time[:2])
    first_win_sec += -int(winning_time[3:])
    if first_win_sec > 59:
        first_win_sec -= 60
        first_win_min += 1
    elif first_win_sec < 0:
        first_win_sec += 60
        first_win_min -= 1
elif second_score > first_score:
    second_win_min += 48 - int(winning_time[:2])
    second_win_sec += -int(winning_time[3:])
    if second_win_sec > 59:
        second_win_sec -= 60
        second_win_min += 1
    elif second_win_sec < 0:
        second_win_sec += 60
        second_win_min -= 1

if first_win_min < 10:
    print("0" + str(first_win_min), end="")
else:
    print(str(first_win_min), end="")
if first_win_sec < 10:
    print(":0" + str(first_win_sec))
else:
    print(":" + str(first_win_sec))

if second_win_min < 10:
    print("0" + str(second_win_min), end="")
else:
    print(str(second_win_min), end="")
if second_win_sec < 10:
    print(":0" + str(second_win_sec))
else:
    print(":" + str(second_win_sec))