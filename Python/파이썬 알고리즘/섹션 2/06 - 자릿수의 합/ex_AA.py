import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
a = list(map(int, input().split()))


def digit_sum(x):
    sum = 0

    # 첫번째 방법
    # while(x > 0):
    #     # 한자리수씩 탐색
    #     sum += x % 10
    #     x = x//10

    # 두번째 방법
    for i in str(x):
        sum += int(i)
    return sum


max = -2147000000
for x in a:
    tot = digit_sum(x)
    if(tot > max):
        max = tot
        res = x

print(res)
