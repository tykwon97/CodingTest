import sys
sys.stdin = open('input.txt', 'rt')
n, m = map(int, input().split())
# 딕셔너리를 사용할 필요가 없었음
arr = {}
for i in range(n):
    for j in range(m):
        num = i+j+2
        if(num in arr):
            arr[num] = arr[num]+1
        else:
            arr[num] = 1

max = -1
# 딕셔너리 .items()를 활용해서 for문 활용
num_list = ''
for index, x in arr.items():
    if(x > max):
        num_list = ''
        max = x
        num_list += str(index) + ' '
    elif(max == x):
        num_list += str(index) + ' '

print(num_list[:-1])
