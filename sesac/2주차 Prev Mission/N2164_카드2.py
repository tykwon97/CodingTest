# list를 활용해 queue를 구현하니 시간이 오래걸리는 문제 발생
# deque사용함으로서 해결

from collections import deque

n = int(input())
queue = deque([(i) for i in range(1, n+1)])

while(len(queue) != 1):
    queue.popleft()
    queue.append(queue.popleft())

print(queue[0])
