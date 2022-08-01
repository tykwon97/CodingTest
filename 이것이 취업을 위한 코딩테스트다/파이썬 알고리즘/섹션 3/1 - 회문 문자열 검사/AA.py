import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())


def palindrome(x):  # 회문
    cnt = len(x)
    for i in range(cnt//2):
        if(x[i] != x[cnt-1-i]):
            return 'NO'
    return 'YES'


for i in range(n):
    s = input()
    print(f'#{i+1} {palindrome(s.lower())}')
