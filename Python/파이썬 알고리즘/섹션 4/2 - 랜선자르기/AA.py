import sys
sys.stdin = open('input.txt', 'rt')
n, k = map(int, input().split())
a = []
for _ in range(n):
    a.append(int(input()))
a.sort()

# 해결못함

cnt = 0
size = a[0]
for i in range(n):
    cnt += a[i]//size

if(cnt < k):
    # print('1')
    while(cnt < k):
        cnt = 0
        for i in range(n):
            cnt += a[i]//size
        size -= 10
    size += 10

    pivot = cnt
    while(pivot <= cnt):
        cnt = 0
        size += 1
        for i in range(n):
            cnt += a[i]//size
else:
    # print('2')
    while(cnt > k):
        cnt = 0
        for i in range(n):
            cnt += a[i]//size
        # print(size, cnt)
        size += 10
    size -= 10

    if(cnt >= k):
        while(k != cnt+1):
            cnt = 0
            size += 1
            for i in range(n):
                cnt += a[i]//size
            print(size, cnt)
    else:
        while(k != cnt):
            cnt = 0
            size -= 1
            for i in range(n):
                cnt += a[i]//size
            if(cnt > k):
                break
            print(size, cnt)
        size += 1
print(size-1)
