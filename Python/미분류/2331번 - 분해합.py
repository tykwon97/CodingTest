n = int(input())
arr = []

for i in range(n-1, 0, -1):
    total = i

    temp = str(i)
    for x in temp:
        total += int(x)
    if(n == total):
        arr.append(i)
arr.sort()
if(len(arr) == 0):
    print(0)
else:
    print(arr[0])
