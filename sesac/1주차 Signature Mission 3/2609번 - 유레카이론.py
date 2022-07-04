from itertools import combinations_with_replacement

n = int(input())
arr = []
for i in range(1, 45):
    arr.append((i*i+i)//2)
# print(arr)
for _ in range(n):
    m = int(input())
    for i, j, k in combinations_with_replacement(arr, 3):
        if(i > m or j > m or k > m):
            # print(" * ", i, j, k)
            continue
        # print(i, j, k)
        if(i+j+k == m):
            print(1)
            break
    else:
        print(0)
