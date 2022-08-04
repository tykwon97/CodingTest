n, m = map(int, input().split())
prefix = set()
for _ in range(n):
    stack = list(input())
    while(stack):
        prefix.add(''.join(stack))
        stack.pop()

count = 0

for _ in range(m):
    x = input()
    if(x in prefix):
        count += 1

print(count)
