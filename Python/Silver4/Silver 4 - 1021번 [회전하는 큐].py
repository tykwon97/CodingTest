from collections import deque
n, m = map(int, input().split())

index = list(map(int, input().split()))
arr = deque([i for i in range(1, n+1)])

count = 0

for i in range(m):
    size = len(arr)
    if(size % 2 == 1):
        pivot = size//2+1+0.5
    else:
        pivot = size//2+1

    loc = -1
    for j, x in enumerate(arr):
        if(x == index[i]):
            loc = j+1
    # print('loc : ', loc, ' pivot : ', pivot)

    if(loc < pivot):
        # print('count1 : ', loc-1)
        for _ in range(loc-1):
            arr.append(arr.popleft())
            count += 1
        arr.popleft()
    else:
        # print('count2 : ', size-loc+1)
        for _ in range(size-loc+1):
            arr.appendleft(arr.pop())
            count += 1
        arr.popleft()

    # print(arr)
print(count)
