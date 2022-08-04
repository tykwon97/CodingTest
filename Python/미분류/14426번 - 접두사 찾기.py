# 시간 초과

n, m = map(int, input().split())
arr = []
prefix = []
for _ in range(n):
    arr.append(input())

for _ in range(m):
    prefix.append(input())

count = 0
for x in prefix:
    index = len(x)
    for y in arr:
        if(x == y[:index]):
            count += 1
            break
print(count)
