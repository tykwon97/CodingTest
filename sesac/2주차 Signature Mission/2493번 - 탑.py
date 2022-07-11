from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
userInput = list(map(int, input().split()))

stack = []

# 시간 너무 오래 걸림...
for i in range(n):
    x = userInput[i]
    arr = stack[:]
    stack.append(x)

    count = 0
    while(len(arr) != 0 and arr[-1] <= x):
        arr.pop()
        count += 1
    print(i-count, end=" ")

# 시간 너무 오래 걸림...
# for i in range(n):
#     for j in range(i-1, -1, -1):
#         if(arr[i] < arr[j]):
#             print(j+1, end=" ")
#             break
#     else:
#         print('0', end=" ")
