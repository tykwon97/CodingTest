import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = list(map(int, input().split()))


def digit_sum(arr):
    max = -1
    max_index = 0
    for index, x in enumerate(arr):
        value = 0
        x = str(x)
        for i in range(len(x)):
            value += int(x[i])
        if(value > max):
            max = value
            max_index = index
    return arr[max_index]


print(digit_sum(arr))
