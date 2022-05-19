import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

cnt = 0
for i in range(n):
    for j in range(n):
        if(j > 0 and arr[i][j] < arr[i][j-1]):  # 상
            continue
        if(j < n-1 and arr[i][j] < arr[i][j+1]):  # 하
            continue
        if(i > 0 and arr[i][j] < arr[i-1][j]):  # 좌
            continue
        if(i < n-1 and arr[i][j] < arr[i+1][j]):  # 우
            continue

        cnt += 1
print(cnt)
