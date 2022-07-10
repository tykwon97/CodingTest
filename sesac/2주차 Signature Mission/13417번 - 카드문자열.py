from collections import deque

n = int(input())

for _ in range(n):
    x = input()  # 딱히 쓸모없음
    str = list(input().split())
    queue = deque([])
    for x in str:
        if(len(queue) == 0):
            queue.append(x)
        else:
            if(ord(queue[0]) >= ord(x)):
                queue.appendleft(x)
            else:
                queue.append(x)
    print("".join(queue))
