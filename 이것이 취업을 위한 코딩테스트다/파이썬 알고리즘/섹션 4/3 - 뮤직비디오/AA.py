import sys
sys.stdin = open('input.txt', 'rt')
n, m = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
# 해결못함
total = sum(a)
print(total)
print(total//(m), total//(m+1))
temp = 0
max_value = -1
for i in range(n):
    if(total//(m+1) > temp):
        temp += a[i]
    else:
        if(max_value < temp):
            max_value = temp
        temp = a[i]

    print(a[i], max_value, temp)
print(a[i], max_value, temp)
if(max_value < temp):
    max_value = temp
print(max_value)

# 10 3 -> 16
# 6 5 8 5 6 8 7 6 6 7
# 6 5 8 5 : 24
# 6 8 7 : 21
# 6 6 7 : 19

# 21
