import sys

x, y, max_x, max_y, min_x, min_y = 500, 500, 500, 500, 500, 500

def move_one_time(cur_dir, move):
    global x, y, max_x, max_y, min_x, min_y
    if move == 'F':
        if cur_dir == 0:
            x += 1
        elif cur_dir == 1:
            x -= 1
        elif cur_dir == 2:
            y += 1
        elif cur_dir == 3:
            y -= 1
    elif move == 'B':
        if cur_dir == 0:
            x -= 1
        elif cur_dir == 1:
            x += 1
        elif cur_dir == 2:
            y -= 1
        elif cur_dir == 3:
            y += 1

    if x > max_x:
        max_x = x
    elif x < min_x:
        min_x = x
    if y > max_y:
        max_y = y
    elif y < min_y:
        min_y = y


def change_dir_one_time(cur_dir, move):
    if move == 'L':
        if cur_dir == 0:
            return 2
        elif cur_dir == 1:
            return 3
        elif cur_dir == 2:
            return 1
        elif cur_dir == 3:
            return 0
    elif move == 'R':
        if cur_dir == 0:
            return 3
        elif cur_dir == 1:
            return 2
        elif cur_dir == 2:
            return 0
        elif cur_dir == 3:
            return 1

def solution(case):
    global x, y, is_visited, max_x, max_y, min_x, min_y
    x, y, max_x, max_y, min_x, min_y = 500, 500, 500, 500, 500, 500
    # direction = [plusx, minusx, plusy, minusy]
    cur_dir = 2
    for move in case:
        if move == 'F' or move == 'B':
            move_one_time(cur_dir, move)
        else:
            cur_dir = change_dir_one_time(cur_dir, move)
    print((max_x - min_x) * (max_y - min_y))

test_case = int(sys.stdin.readline())
while test_case > 0:
    solution(sys.stdin.readline().rstrip())
    test_case -= 1
