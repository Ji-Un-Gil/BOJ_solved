def solution(record):
    answer = []
    ids = {}
    record_list = [[0]*3 for f in range(len(record))]
    for i in range(len(record)):
        record_list[i] = record[i].split(' ')

    for j in range(len(record_list)):
        if record_list[j][0] == 'Enter':
            ids[record_list[j][1]] = record_list[j][2]
        elif record_list[j][0] == 'Change':
            ids[record_list[j][1]] = record_list[j][2]
        else:
            continue

    for k in range(len(record_list)):
        if record_list[k][0] == 'Enter':
            answer.append(ids[record_list[k][1]] + '님이 들어왔습니다.')
        elif record_list[k][0] == 'Leave':
            answer.append(ids[record_list[k][1]] + '님이 나갔습니다.')

    return answer