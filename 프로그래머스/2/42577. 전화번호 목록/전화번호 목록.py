def solution(phone_book):
    answer = True
    phone_book.sort(key=len)
    dicA = {}
    dicB = {}
    lstA = []
    lstB = []
    length = []
    for i in range(len(phone_book)):
        if len(phone_book[i]) in length:
            continue
        else:
            for j in range(i, len(phone_book)):
                if len(phone_book[j]) == len(phone_book[i]):
                    lstA.append(phone_book[j][:len(phone_book[i])])
                else:
                    lstB.append(phone_book[j][:len(phone_book[i])])
            dicA[len(phone_book[i])] = lstA
            dicB[len(phone_book[i])] = lstB
            lstA = []
            lstB = []
            length.append(len(phone_book[i]))

    for k in range(len(length)):
        tempA = dicA[length[k]]
        tempB = dicB[length[k]]
        tempB = list(set(tempB))
        temp_total = tempA + tempB
        if len(temp_total) != len(set(temp_total)):
            answer = False
            break

    return answer