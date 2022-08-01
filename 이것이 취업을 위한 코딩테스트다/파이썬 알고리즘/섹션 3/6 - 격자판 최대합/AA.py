import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
sum_max = -1

# 대각선
diagonal_1 = 0
diagonal_2 = 0

for i in range(n):
    # 대각선
    diagonal_1 += arr[i][i]
    diagonal_2 += arr[n-1-i][i]

    # 가로,세로
    row = 0
    column = 0
    for j in range(n):
        row += arr[i][j]
        column += arr[j][i]
    if(sum_max < max(row, column)):
        sum_max = max(row, column)

# 대각선
if(sum_max < max(diagonal_1, diagonal_2)):
    sum_max = max(diagonal_1, diagonal_2)

print(sum_max)
