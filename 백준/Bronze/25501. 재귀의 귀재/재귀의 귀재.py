import sys

recursion_try = 0

def recursion(s, l, r):
    global recursion_try
    recursion_try += 1
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: return recursion(s, l+1, r-1)

def isPalindrome(s):
    global recursion_try
    recursion_try = 0
    return recursion(s, 0, len(s)-1)

T = int(sys.stdin.readline())
for i in range(T):
    print(isPalindrome(sys.stdin.readline().rstrip()), recursion_try)