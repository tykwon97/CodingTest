import sys
sys.stdin = open('input.txt', 'rt')
n, k = map(int, input().split())
a = list(map(int, input().split()))
res = set()  # set : 중복 제거
for i in range(n):
    for j in range(i+1, n):
        for m in range(j+1, n):
            res.add(a[i]+a[j]+a[m])
res = list(res)  # set은 sort가 안되므로 list로 변경
res.sort(reverse=True)
print(res)
print(res[k-1])
