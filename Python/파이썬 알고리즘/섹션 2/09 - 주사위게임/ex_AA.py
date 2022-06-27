import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
res = 0
for i in range(n):
    tmp = input().split()
    tmp.sort()
    a, b, c = map(int, tmp)

    # if문 사용시 가장 좋은 것을 가장 먼저 사용
    if(a == b and b == c):
        money = 10000+a*1000
    elif(a == b or a == c):
        money = 1000+a*100
    elif(b == c):
        money = 1000+b*100
    else:
        money = 100*c  # 오름차순 되어있음
    if(money > res):
        res = money
print(res)
