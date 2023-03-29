def calculate_diff(ryan, apeach):
    diff = 0
    for idx in range(len(apeach)):
        if ryan[idx] > apeach[idx]:
            diff += (10 - idx)
        elif ryan[idx] < apeach[idx]:
            diff -= (10 - idx)
    return diff


def compare_best_result(diff, diff2, ryan, ryan2):
    if diff == diff2:
        for idx in range(10, -1, -1):
            if ryan[idx] < ryan2[idx]:
                return ryan2
            elif ryan[idx] > ryan2[idx]:
                return ryan
        return ryan
    elif diff > diff2:
        return ryan
    return ryan2


def solution(n, apeach):
    arrows_left = n
    ryan = [0 for i in range(11)]
    winning_shots = [arrow + 1 for arrow in apeach]
    efficiencies = []
    for idx in range(len(apeach)):
        efficiency = 10 - idx
        if apeach[idx] > 0:
            efficiency *= 2
        efficiencies.append(efficiency / winning_shots[idx])

    while sum(efficiencies) > -10:
        for idx in range(len(efficiencies)):
            if efficiencies[idx] == max(efficiencies):
                if arrows_left >= winning_shots[idx]:
                    ryan[idx] = winning_shots[idx]
                    arrows_left -= winning_shots[idx]
                else:
                    ryan[idx] = 0
                efficiencies[idx] = -1
                # 테케1 반례
                break
    if arrows_left > 0:
        ryan[-1] = arrows_left

    diff = calculate_diff(ryan, apeach)

    ryan2 = [0 for i in range(11)]
    diff2 = 0
    arrows_max = 1
    arrows_left = n
    while arrows_max <= n:
        possible_ryan = [0 for i in range(11)]
        for apeach_hit in range(len(apeach)):
            if 0 < apeach[apeach_hit] < arrows_left and apeach[apeach_hit] <= arrows_max:
                possible_ryan[apeach_hit] = apeach[apeach_hit] + 1
                arrows_left -= (apeach[apeach_hit] + 1)
            apeach_miss = 10 - 2 * (10 - apeach_hit)
            if apeach_miss >= 0:
                if arrows_left > apeach[apeach_miss] and possible_ryan[apeach_miss] == 0:
                    possible_ryan[apeach_miss] = apeach[apeach_miss] + 1
                    arrows_left -= (apeach[apeach_miss] + 1)
                apeach_miss += 1
                if apeach_miss > 10:
                    break
                if arrows_left > apeach[apeach_miss] and possible_ryan[apeach_miss] == 0:
                    possible_ryan[apeach_miss] = apeach[apeach_miss] + 1
                    arrows_left -= (apeach[apeach_miss] + 1)
        if arrows_left > 0:
            possible_ryan[-1] = arrows_left
        possible_diff = calculate_diff(possible_ryan, apeach)
        result = compare_best_result(diff2, possible_diff, ryan2, possible_ryan)
        if result != ryan2:
            diff2 = possible_diff
            ryan2 = result
        arrows_max += 1

    ryan = compare_best_result(diff, diff2, ryan, ryan2)
    if ryan == ryan2:
        diff = diff2

    ryan3 = [0 for i in range(11)]
    arrows_left = n
    for apeach_hit in range(len(apeach)):
        if 0 < apeach[apeach_hit] < arrows_left:
            ryan3[apeach_hit] = apeach[apeach_hit] + 1
            arrows_left -= (apeach[apeach_hit] + 1)
        apeach_miss = 10 - 2 * (10 - apeach_hit)
        if apeach_miss >= 0:
            if arrows_left > apeach[apeach_miss] and ryan3[apeach_miss] == 0:
                ryan3[apeach_miss] = apeach[apeach_miss] + 1
                arrows_left -= (apeach[apeach_miss] + 1)
            apeach_miss += 1
            if apeach_miss > 10:
                break
            if arrows_left > apeach[apeach_miss] and ryan3[apeach_miss] == 0:
                ryan3[apeach_miss] = apeach[apeach_miss] + 1
                arrows_left -= (apeach[apeach_miss] + 1)
    if arrows_left > 0:
        ryan3[10] = arrows_left
    diff3 = calculate_diff(ryan3, apeach)

    if diff <= 0 and diff3 <= 0:
        return [-1]
    else:
        return compare_best_result(diff, diff3, ryan, ryan3)