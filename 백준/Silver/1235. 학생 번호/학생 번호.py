import sys

N = int(sys.stdin.readline())
students = []
while N > 0:
    students.append(sys.stdin.readline().rstrip())
    N -= 1

k = 0
slice_idx = -2
while slice_idx >= -len(students[0]):
    slice_result = []
    for string in students:
        slice_result.append(string[-1:slice_idx:-1])
    if len(slice_result) == len(set(slice_result)):
        k = -1 - slice_idx
        break
    slice_idx -= 1

if k == 0:
    k = len(students[0])
print(k)