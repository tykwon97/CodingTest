import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = list(map(int, input().split()))

result = [-1]*n

for i in range(n):
    temp = n-(i+1)
    s = arr[i]
    cnt = 0
    for j in range(n):
        if(cnt == s):
            if(result[j] != -1):
                continue
            result[j] = i+1
            break
        if(result[j] == -1):
            cnt += 1

for x in result:
    print(x, end=' ')
