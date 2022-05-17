import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())

# 시간 오래 걸리는 알고리즘 !! - 20점

decimal = []

for i in range(2, n+1):
    print(i)
    for x in decimal:
        if(i % x == 0):
            break
    else:
        decimal.append(i)

print(len(decimal))
