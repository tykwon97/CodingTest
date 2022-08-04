n, m = map(int, input().split())

notListen = set()
both = []

for _ in range(n):
    notListen.add(input())

for _ in range(m):
    notSee = input()
    if(notSee in notListen):
        both.append(notSee)

print(len(both))
both.sort()
for x in both:
    print(x)
