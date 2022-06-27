import sys
sys.stdin = open('input.txt', 'rt')
arr = []
for _ in range(7):
    arr.append(list(input().split()))

cnt = 0
for i in range(7):
    for j in range(3):
        row_str = arr[i][j:j+5]
        if(row_str[0] == row_str[4] and row_str[1] == row_str[3]):
            cnt += 1

        column_str = ''
        for k in range(5):
            column_str += (arr[j+k][i])
        if(column_str[0] == column_str[4] and column_str[1] == column_str[3]):
            cnt += 1


print(cnt)
