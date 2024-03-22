def solution(numbers):
    answer = ''

    num_1000 = []
    result = []
    numbers = [str(k) for k in numbers]

    for i in numbers:
        if len(i) == 1:
            num_1000.append([i+i+i+i, 1])
        elif len(i) == 2:
            num_1000.append([i+i[0]+i[1], 2])
        elif len(i) == 3:
            num_1000.append([i+i[0], 3])
        else:
            num_1000.append([i, 4])

    num_1000.sort(key=lambda x: x[0], reverse=True)

    for j in num_1000:
        result.append(j[0][0:j[1]])

    answer = ''.join(result)

    total = 0
    for u in numbers:
        total += int(u)
    if total == 0:
        answer = '0'

    return answer