import sys
N = int(input())
lst = []
for i in range(N):
    temp = sys.stdin.readline().rstrip().split()
    lst.append(list(map(int, temp)))

def pool(li, size):
    newli = []
    for x in range(0, size, 2):
        newrow = []
        for y in range(0, size, 2):
            compare = [li[x][y], li[x][y+1], li[x+1][y], li[x+1][y+1]]
            compare.sort(reverse=True)
            newrow.append(compare[1])
        newli.append(newrow)
    return newli

def list_to_num(li, size):
    if size == 1:
        return li
    else:
        newli = pool(li, size)
        size = size // 2
        return list_to_num(newli, size)

answer = list_to_num(lst, N)
print(answer[0][0])