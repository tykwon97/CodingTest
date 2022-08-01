import sys
sys.stdin = open('input.txt', 'rt')
n, m = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
s = 0
e = len(a)-1
i = -1
print(a)
while(s < e):
    pivot = (e-s+1) // 2 - 1 + s
    print(s, ':', a[s], e, ':', a[e], pivot, ':', a[pivot])
    if(a[pivot] == m):
        i = pivot
        break
    elif(a[pivot] > m):
        e = pivot - 1
    elif(a[pivot] < m):
        s = pivot + 1

print(i+1)
