import sys
sys.stdin = open('input.txt', 'rt')

arr = [0]*20
for i in range(1, 21):
    arr[i-1] = i

for _ in range(10):
    n, m = map(int, input().split())
    temp = arr[n-1:m]
    temp.reverse()
    arr = arr[0:n-1]+temp+arr[m:20]

for x in arr:
    print(x, end=' ')
