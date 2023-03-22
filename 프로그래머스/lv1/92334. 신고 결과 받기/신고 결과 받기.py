def solution(id_list, reports, k):
    reported_by_users = {}
    received_mail = {}
    answer = []

    for user in id_list:
        received_mail[user] = 0

    # reports를 바탕으로 신고당한 대상들 각각에 대해 신고자들 명단 제작
    for report in reports:
        user = report.split()[0]
        reported_user = report.split()[1]
        # if문을 한번 더 사용해 중복된 신고를 카운팅하지 않는 방법도 고민
        if reported_user in reported_by_users.keys():
            reported_by_users[reported_user].append(user)
        else:
            reported_by_users[reported_user] = [user]

    for user in id_list:
        # 신고당한 횟수를 비교하는 과정에서 중복된 신고를 삭제
        if (user in reported_by_users.keys()) and (len(set(reported_by_users[user])) >= k):
            for received_user in set(reported_by_users[user]):
                received_mail[received_user] += 1

    for user in id_list:
        answer.append(received_mail[user])
    return answer
