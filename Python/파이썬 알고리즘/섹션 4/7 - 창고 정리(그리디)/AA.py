import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
box = list(map(int, input().split()))
m = int(input())
box.sort()
# print(box)

# 좋지 않은 방식으로 해결
for _ in range(m):
    box[0] += 1
    box[n-1] -= 1
    box.sort()
print(box[n-1]-box[0])
