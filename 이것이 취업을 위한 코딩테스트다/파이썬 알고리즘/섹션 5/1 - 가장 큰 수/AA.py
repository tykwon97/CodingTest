import sys
sys.stdin = open('input.txt', 'rt')
arr, m = input().split()
cnt = len(arr)
m = cnt-int(m)

result = []
while(m > 0):
    maxValue = -1
    maxIndex = 0
    num = 0
    for x in arr:
        if(num == len(arr)-m+1):
            break
        if(maxValue < int(x)):
            maxValue = int(x)
            maxIndex = num
        num += 1
    arr = arr[maxIndex+1:]
    result.append(str(maxValue))
    m -= 1

print("".join(result))  # join은 string리스트만 가능(Int형 불가능)
