import sys
sys.stdin = open('input.txt', 'rt')
n, c = map(int, input().split())
Line = []
for _ in range(n):
    tmp = int(input())
    Line.append(tmp)
Line.sort()


def Count(size):
    cnt = 0
    ep = Line[0]  # ep : End Point
    for i in range(1, n):
        if(Line[i]-ep >= size):
            cnt += 1
            ep = Line[i]

    return cnt


lt = 1
rt = Line[n-1]

while(lt <= rt):
    mid = (lt+rt)//2
    if(Count(mid) >= c):
        res = mid
        lt = mid+1
    else:
        rt = mid-1

print(res)
