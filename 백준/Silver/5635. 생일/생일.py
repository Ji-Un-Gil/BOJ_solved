import sys

student_info = []
n = int(sys.stdin.readline())
while n > 0:
    student_info.append(sys.stdin.readline().split())
    n -= 1

student_info.sort(key=lambda x: (int(x[3]), int(x[2]), int(x[1])))

print(student_info[-1][0])
print(student_info[0][0])