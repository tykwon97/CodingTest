from collections import deque

n, k = map(int, input().split())

arr = deque([i for i in range(1, n+1)])

result = []

while(arr):
    for _ in range(k-1):
        arr.append(arr.popleft())
    result.append(str(arr.popleft()))

print('<', end='')
print(", ".join(result), end='')  # join은 string list만 가능
print('>')
