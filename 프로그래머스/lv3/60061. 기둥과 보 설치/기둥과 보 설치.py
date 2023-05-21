def modifyIsExist(x, y, a, b, is_exist):
    # 하려는 작업이 설치일 경우
    if b == 1:
        flag = False
        if a == 0:
            flag = isValidColumn(x, y, is_exist)
        elif a == 1:
            flag = isValidRow(x, y, is_exist)
        if flag:
            is_exist[x][y][a] = 1
        return
    # 하려는 작업이 삭제일 경우
    flag = True
    is_exist[x][y][a] = 0
    for i in range(len(is_exist)):
        for j in range(len(is_exist)):
            if (is_exist[i][j][0] == 1 and not isValidColumn(i, j, is_exist)) or (is_exist[i][j][1] == 1 and not isValidRow(i, j, is_exist)):
                flag = False
                break
        if not flag:
            break
    if not flag:
        is_exist[x][y][a] = 1


def isNotInRange(x, y, length):
    if 0 <= x < length and 0 <= y < length:
        return False
    return True


def isValidColumn(x, y, is_exist):
    # 기둥이 바닥 위에 있거나, 다른 기둥 위에 있는 경우
    if x == 0 or is_exist[x-1][y][0] == 1:
        return True
    if not isNotInRange(x, y-1, len(is_exist)):
        # 기둥이 보의 한쪽 끝 부분 위에 있는 경우
        if is_exist[x][y-1][1] == 1 or is_exist[x][y][1] == 1:
            return True
    else:
        if is_exist[x][y][1] == 1:
            return True
    return False


def isValidRow(x, y, is_exist):
    if x == 0:
        return False
    # 보의 한쪽 끝 부분이 기둥 위에 있는 경우
    if is_exist[x-1][y][0] == 1 or (y+1 <= len(is_exist[0])-1 and is_exist[x-1][y+1][0] == 1):
        return True
    # 보의 양쪽 끝 부분이 다른 보와 연결된 경우
    if not isNotInRange(x, y-1, len(is_exist)) and not isNotInRange(x, y+1, len(is_exist)) and is_exist[x][y-1][1] == 1 and is_exist[x][y+1][1] == 1:
        return True
    return False


def solution(n, build_frame):
    answer = []
    is_exist = [[[0, 0] for i in range(n+1)] for j in range(n+1)]
    for frame in build_frame:
        modifyIsExist(frame[1], frame[0], frame[2], frame[3], is_exist)

    for i in range(len(is_exist)):
        for j in range(len(is_exist[0])):
            if is_exist[i][j][0] == 1:
                answer.append([j, i, 0])
            if is_exist[i][j][1] == 1:
                answer.append([j, i, 1])

    answer = sorted(answer, key=lambda x: (x[0], x[1], x[2]))
    return answer