import sys

car_num = int(sys.stdin.readline())
cars_in, cars_out = [], []
for num in range(car_num):
    cars_in.append(sys.stdin.readline().rstrip())
for num in range(car_num):
    cars_out.append(sys.stdin.readline().rstrip())

in_idx, out_idx, answer = 0, 0, 0
overtake = []
while in_idx < len(cars_in):
    if cars_in[in_idx] in overtake:
        in_idx += 1
        continue
    while out_idx < len(cars_out):
        if cars_in[in_idx] == cars_out[out_idx]:
            in_idx += 1
            out_idx += 1
            break
        overtake.append(cars_out[out_idx])
        answer += 1
        out_idx += 1

print(answer)