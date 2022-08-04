n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    result = a
    for _ in range(b-1):
        result = result*a % 10
    print(result)
