# while문을 사용해서 n과 m을 0 0 이 들어올때까지 반복했어야했는데
# 문제를 잘못 이해함

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
while(n != 0 and m != 0):
    arr = set()
    count = 0

    for _ in range(n):
        x = int(input())
        arr.add(x)

    for _ in range(m):
        x = int(input())
        if(x in arr):
            count += 1

    n, m = map(int, input().split())  # 0,0

    print(count)
