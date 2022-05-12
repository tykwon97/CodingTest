import sys
sys.stdin=open('input.txt', 'rt')
n,k = map(int,input().split())
arr = []
for i in range(n//2):
	if(n%(i+1) == 0):
		arr.append(i+1)
arr.append(n)

if(k > len(arr)):
	print(-1)
else:
	print(arr[k-1])