import sys
sys.stdin = open('input.txt', 'rt')
n, m = map(int, input().split())
people = list(map(int, input().split()))
people.sort()

s = 0
e = n-1
cnt = 0

while(s <= e):
    if(people[s] + people[e] <= m):
        s += 1
        e -= 1
        cnt += 1
    else:
        cnt += 1
        e -= 1

print(cnt)
