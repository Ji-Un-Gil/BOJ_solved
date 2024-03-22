def solution(citations):
    answer = len(citations)

    citations.sort(reverse=True)
    for i in range(len(citations)):
        if i+1 > citations[i]:
            answer = i
            break

    return answer