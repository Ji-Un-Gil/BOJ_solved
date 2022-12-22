import sys

input = sys.stdin.readline

global count

def recursion(word, l, r):

    global count
    count += 1

    if l >= r :
        return 1
    elif word[l] != word[r]:
        return 0
    else:
        return recursion(word, l+1, r-1)

def isPalindrome(word):
    return recursion(word, 0, len(word)-1)

result=[]

for i in range(int(input())):
    count = 0
    print(isPalindrome(input().rstrip()), count)