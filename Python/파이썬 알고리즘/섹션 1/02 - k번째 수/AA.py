import sys
#sys.stdin=open('input.txt','rt')
t = int(input())

for i in range(t):
    n,s,e,k = map(int, input().split())
    arr = list(map(int,input().split()))
    
    # sort방식 1
    # arr = arr[s-1:e]
    # arr.sort()

    # sort방식 2
    arr = sorted(arr[s-1:e])

    print('#',i+1,sep='',end=' ')
    print(arr[k-1])
