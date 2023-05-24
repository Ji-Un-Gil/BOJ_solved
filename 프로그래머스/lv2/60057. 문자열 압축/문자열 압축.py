def solution(s):
    answer = 0

    count = 1
    str_len = ['' for f in range(len(s))]

    for i in range(1, len(s)):
        k = 0
        while k+i+i <= len(s):
            if s[k:k+i] == s[k+i:k+i+i]:
                count += 1

            else:
                if count == 1:
                    str_len[i-1] = str_len[i-1] + s[k:k+i]
                else:
                    str_len[i-1] = str_len[i-1] + str(count) + s[k:k+i]
                    count = 1
            k += i
        if count == 1:
            str_len[i-1] = str_len[i-1] + s[k:len(s)]
        else:
            str_len[i-1] = str_len[i-1] + str(count) + s[k:len(s)]
            count = 1


    min_len = len(str_len[0])

    for j in range(len(str_len)-1):
        if min_len > len(str_len[j]):
            min_len = len(str_len[j])
    if len(s) == 1:
        min_len = 1

    answer = min_len
    return answer