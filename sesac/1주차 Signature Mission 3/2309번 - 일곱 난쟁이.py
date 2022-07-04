from itertools import combinations

arr = list(int(input()) for _ in range(9))

total = sum(arr) - 100

for i, j in combinations(arr, 2):
    if(i+j == total):
        arr.remove(i)
        arr.remove(j)
        break

arr.sort()
for x in arr:
    print(x)
