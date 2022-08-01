import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


# 테두리에 0 추가
a.insert(0, [0]*n)
a.append([0]*n)
for x in a:
    x.insert(0, 0)
    x.append(0)

cnt = 0
for i in range(1, n+1):
    for j in range(1, n+1):
        if(all(a[i][j] > a[i+dx[k]][j+dy[k]] for k in range(4))):  # 파이썬 all과 for문 사용
            cnt += 1

print(cnt)
