from collections import deque

n = int(input())

move = list(map(int, input().split()))

arr = deque([int(i) for i in range(n)])

result = []

for i in range(n):
    index = arr.popleft()
    result.append(index+1)
    num = move[index]
    if(num > 0):
        num -= 1
    while(num != 0 and len(arr) > 1):
        if(num > 0):
            arr.append(arr.popleft())
            num -= 1
        else:
            arr.appendleft(arr.pop())
            num += 1

    # print(i, arr, result)

print(*result)
