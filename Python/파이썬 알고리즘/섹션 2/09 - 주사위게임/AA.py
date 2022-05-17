import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
max_value = -1

for _ in range(n):
    arr = list(map(int, input().split()))
    arr_count = len(set(arr))
    if(arr_count == 1):
        value = 10000+arr[0]*1000
    elif(arr_count == 2):
        for i in range(2):
            if(arr.count(arr[i]) == 2):
                break
        value = 1000+arr[i]*100
    elif(arr_count == 3):
        value = max(arr)*100
    if(max_value < value):
        max_value = value

print(max_value)
