from itertools import combinations

n, m = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()
maxValue = -1

for i, j, k in combinations(arr, 3):
    if(maxValue < i+j+k <= m):
        maxValue = i+j+k
print(maxValue)
