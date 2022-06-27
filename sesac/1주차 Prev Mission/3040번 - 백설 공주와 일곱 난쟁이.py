from itertools import combinations

arr = list(int(input()) for _ in range(9))

total = sum(arr) - 100

for i, j in combinations(arr, 2):
    if(i+j == total):
        for x in arr:
            if(x != i and x != j):
                print(x)
