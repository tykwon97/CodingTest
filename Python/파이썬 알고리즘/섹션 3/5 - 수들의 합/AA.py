import sys
sys.stdin = open('input.txt', 'rt')
n, m = map(int, input().split())
a = list(map(int, input().split()))
start = -1
end = 0
sum = 0
cnt = 0

while(start != n):
    if(sum < m):
        start += 1
        if(start != n):
            sum += a[start]
    elif(sum == m):
        start += 1
        if(start != n):
            sum += a[start]
        cnt += 1
    else:  # (sum>m):
        sum -= a[end]
        end += 1

print(cnt)
