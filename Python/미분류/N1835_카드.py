from collections import deque

n = int(input())
queue = deque([n])

while(n > 1):
    n -= 1
    queue.appendleft(n)
    for _ in range(n):
        x = queue.pop()
        queue.appendleft(x)

print(*queue)
