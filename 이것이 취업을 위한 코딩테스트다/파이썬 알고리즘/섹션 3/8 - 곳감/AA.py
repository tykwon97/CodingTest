import sys
sys.stdin = open('input.txt', 'rt')

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

m = int(input())
for _ in range(m):
    line, dir, count = (map(int, input().split()))
    if(count >= n):
        count %= n
    if(dir == 0):
        arr[line-1] = arr[line-1][count:n] + arr[line-1][0:count]
    elif(dir == 1):
        arr[line-1] = arr[line-1][n-count:n] + arr[line-1][0:n-count]

sum = 0
for i in range(n//2):
    for j in range(i, n-i):
        sum += arr[i][j]
        sum += arr[n-1-i][j]
sum += arr[n//2][n//2]
print(sum)
