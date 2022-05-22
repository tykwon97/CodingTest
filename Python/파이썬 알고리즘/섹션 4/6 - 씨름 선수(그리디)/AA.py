import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
applicant = []
for _ in range(n):
    applicant.append(tuple(map(int, input().split())))
applicant.sort()

cnt = n
# for x in applicant:
#     print(x)

for i in range(n):
    weight = applicant[i][1]
    for j in range(i, n):
        if(weight < applicant[j][1]):
            cnt -= 1
            print(i, j)
            break

print(cnt)
