n, m = map(int, input().split())

notListen = set()
notSee = set()

for _ in range(n):
    notListen.add(input())

for _ in range(m):
    notSee.add(input())

both = notListen & notSee
print(len(both))

for x in sorted(both):
    print(x)
