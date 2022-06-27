# 증가수열 : 일정한 차가 아닌 증가만 하면됨!!!!
import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
str = list(map(int, input().split()))
# print(str)
s = 0
e = n-1
cnt = 0

arr = [[-1, 'L']]
while(s <= e):

    num = len(arr)
    x = arr[num-1][0]
    # print(str[s], str[e])
    if(s == e and arr[s][0] > x):
        arr.append((str[s], 'L'))
        break

    if(str[s] <= str[e]):
        if(str[s] == 2147000000):
            break
        if(str[s] < x):
            str[s] = 2147000000
        else:
            arr.append((str[s], 'L'))
            s += 1
    else:
        if(str[e] < x):
            str[e] = 2147000000
        else:
            arr.append((str[e], 'R'))
            e -= 1
arr.pop(0)
print(arr)

num = len(arr)
str = ''
print(num)
for x, y in arr:
    print(y, end='')
