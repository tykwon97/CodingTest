n = int(input())
arr = set()

for _ in range(n):
    name, method = input().split()
    if(method == "enter"):
        arr.add(name)
    else:
        arr.remove(name)
a = sorted(arr, reverse=True)
for x in a:
    print(x)
