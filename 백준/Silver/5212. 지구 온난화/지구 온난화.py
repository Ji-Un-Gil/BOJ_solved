import sys

R, C = map(int, sys.stdin.readline().rstrip().split())
cur_map = []

while R > 0:
    cur_map.append(sys.stdin.readline().rstrip())
    R -= 1

future_map = []
for i in range(len(cur_map)):
    future_row = ""
    for j in range(C):
        join_island = 0
        if cur_map[i][j] == 'X':
            if i - 1 < 0 or cur_map[i - 1][j] == '.':
                join_island += 1
            if i + 1 >= len(cur_map) or cur_map[i + 1][j] == '.':
                join_island += 1
            if j - 1 < 0 or cur_map[i][j - 1] == '.':
                join_island += 1
            if j + 1 >= C or cur_map[i][j + 1] == '.':
                join_island += 1
            if join_island > 2:
                future_row += "."
            else:
                future_row += "X"
        else:
            future_row += "."
    future_map.append(future_row)

min_row, min_column = len(future_map) - 1, len(future_map[0]) - 1
max_row, max_column = 0, 0
for i in range(len(future_map)):
    for j in range(len(future_map[0])):
        if future_map[i][j] == 'X':
            if i > max_row:
                max_row = i
            if i < min_row:
                min_row = i
            if j > max_column:
                max_column = j
            if j < min_column:
                min_column = j

for i in range(min_row, max_row + 1):
    print(future_map[i][min_column:max_column + 1])