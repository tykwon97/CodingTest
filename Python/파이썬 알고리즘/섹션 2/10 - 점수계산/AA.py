import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = list(map(int, input().split()))

total_score = 0
score = 0
for i in range(len(arr)):
    if(arr[i] == 1):
        score += 1
    else:
        score = 0
    total_score += score

print(total_score)
