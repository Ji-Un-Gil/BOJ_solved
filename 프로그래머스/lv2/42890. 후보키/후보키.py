from itertools import combinations

def solution(relation):
    answer = 0
    overlap = {}
    overlap_cb = {}
    for i in range(len(relation[0])):
        temp = []
        for j in range(len(relation)):
            for k in range(len(temp)):
                if relation[j][i] == temp[k][1]:
                    if temp[k][0] != -1:
                        if i in overlap.keys():
                            if temp[k][1] in overlap[i].keys():
                                overlap[i][temp[k][1]].append(temp[k][0])
                            else:
                                overlap[i][temp[k][1]] = [temp[k][0]]
                        else:
                            overlap[i] = {temp[k][1]: [temp[k][0]]}
                        temp[k][0] = -1
                    overlap[i][temp[k][1]].append(j)
                    break
            temp.append([j, relation[j][i]])
        temp.clear()

    #단일 후보 키
    answer += len(relation[0]) - len(overlap.keys())

    for i in range(len(relation[0])):
        if i in overlap.keys():
            for key in overlap[i].keys():
                if i in overlap_cb.keys():
                    overlap_cb[i] += list(combinations(overlap[i][key], 2))
                else:
                    overlap_cb[i] = list(combinations(overlap[i][key], 2))
    print(overlap)
    print(overlap_cb)
    answer += dict_cb(overlap_cb)
    return answer

def dict_cb(dic):
    cb_num = 2  #결합할 애트리뷰트 수
    candidate = []  # 확인된 후보키 조합
    cand_num = 0
    while cb_num <= len(dic.keys()):
        check = list(combinations(dic.keys(), cb_num))
        for i in range(len(check)):
            compare = []
            for j in range(len(check[i])):
                compare += dic[check[i][j]]
            flag = True
            for k in range(len(compare)):
                if compare.count(compare[k]) == cb_num: #유일성 조건 미달
                    flag = False
                    break
            if flag:
                candidate.append(check[i])
        cb_num += 1

    for i in range(len(candidate)):
        if len(candidate[i]) == 0:
            continue
        erase = []
        for j in range(i+1, len(candidate)):
            if candidate[i] in list(combinations(candidate[j], len(candidate[i]))):
                erase.append(j)
        for k in range(len(erase)):
            candidate[erase[k]] = []

    for n in range(len(candidate)):
        if len(candidate[n]) != 0:
            cand_num += 1

    return cand_num