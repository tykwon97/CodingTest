from itertools import combinations


n = int(input())

arr1 = []
arr2 = []
arr3 = []

arr = []
count = 0

for _ in range(n):
    n, s, b = map(int, input().split())
    n_1 = n//100
    n_2 = n % 100//10
    n_3 = n % 10

    count = s+b

    arr.append(n_1)
    arr.append(n_2)
    arr.append(n_3)
