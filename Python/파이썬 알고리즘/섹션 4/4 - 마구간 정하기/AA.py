import sys
sys.stdin = open('input.txt', 'rt')
n, c = map(int, input().split())

# 해설 참조해서 직접 품
a = []
diff = []
for _ in range(n):
    a.append(int(input()))
a.sort()

lt = a[0]
rt = a[n-1]


def Count(size):
    cnt = 1
    tot = 0
    for i in range(0, n-1):
        x = a[i+1]-a[i]
        if(tot + x >= size):
            tot = 0
            cnt += 1
        else:
            tot += x
    return cnt


res = 0
while(lt <= rt):
    mid = (lt+rt)//2
    print(lt, rt, mid, Count(mid), c)
    if(Count(mid) >= c):
        lt = mid + 1
        res = mid
    else:
        rt = mid - 1

print(res)
