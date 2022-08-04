import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = []

for _ in range(n):
    heapq.heappush(arr, int(input()))

result = 0
while(arr and len(arr) > 1):
    x = heapq.heappop(arr)
    y = heapq.heappop(arr)

    result += x+y
    if(len(arr) == 0):
        break

    heapq.heappush(arr, x+y)

print(result)
