import sys


def solution(key, lock):

    def valid_lock(lock):
        for i in range(len(lock)):
            for j in range(len(lock[0])):
                if lock[i][j] == 0:
                    return True
        return False

    def rotate_key(possible_key):
        result = []
        for j in range(len(possible_key[0])):
            fragment = []
            for i in range(len(possible_key) - 1, -1, -1):
                fragment.append(possible_key[i][j])
            result.append(fragment)
        return result

    def padding_key(possible_key, lock_x_len, lock_y_len):
        result = [[0 for i in range(lock_x_len*2+len(possible_key)-2)] for j in range(lock_y_len*2+len(possible_key[0])-2)]
        for k in range(lock_x_len-1, lock_x_len-1+len(possible_key)):
            for l in range(lock_y_len-1, lock_y_len-1+len(possible_key[0])):
                result[k][l] = possible_key[k-(lock_x_len-1)][l-(lock_y_len-1)]
        return result

    def valid_key(possible_key, lock):
        for i in range(len(possible_key)-len(lock)+1):
            for j in range(len(possible_key[0])-len(lock[0])+1):
                flag = True
                for x in range(i, i+len(lock)):
                    for y in range(j, j+len(lock[0])):
                        if (possible_key[x][y] == 1 and lock[x-i][y-j] == 1) or (possible_key[x][y] == 0 and lock[x-i][y-j] == 0):
                            flag = False
                            break
                    if not flag:
                        break
                if flag:
                    return True
        return False

    if not valid_lock(lock):
        return True

    key = [key]
    for i in range(3):
        key.append(rotate_key(key[-1]))
    for i in range(4):
        key[i] = padding_key(key[i], len(lock), len(lock[0]))

    answer = False
    for i in range(4):
        if valid_key(key[i], lock):
            return True
    return answer