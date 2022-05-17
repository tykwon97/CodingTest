import sys
#sys.stdin = open('input.txt', 'rt')
n = int(input())
a = list(map(int, input().split()))

arr = sorted(a)
avg = round(sum(a)/n)
arr = list(map(lambda x: x-avg, arr))

index = -1
minValue = abs(arr[0])

for i in range(n):
    if(abs(arr[i]) <= minValue):
        if(arr[i] >= 0):
            minValue = arr[i]
            break
        minValue = abs(arr[i])

for i in range(n):
    if(a[i] == minValue+avg):
        index = i+1
        break

print(avg, index, sep=' ')
