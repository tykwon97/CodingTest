import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

sum = 0

for i in range(n):
    if(i < n//2):
        for j in range(n//2 - i,  n-1 - n//2 + i + 1):
            sum += arr[i][j]
    elif(i == n//2):
        for j in range(n):
            sum += arr[i][j]
    else:
        for j in range(i - n//2, n - i + n//2):
            sum += arr[i][j]

print(sum)
