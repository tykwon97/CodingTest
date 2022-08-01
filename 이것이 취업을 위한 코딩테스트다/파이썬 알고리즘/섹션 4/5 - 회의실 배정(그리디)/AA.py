import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
a.sort()

# 시간초과
# 모든 경우의 수를 탐색할 필요가 없었음!! -> greedy algorithm


def conference(arr, start, cnt):
    new_arr = arr[:]
    # print(arr)
    # print('start : ', start, 'cnt : ', cnt, 'len(arr) : ', len(arr))

    # 해당 회의를 진행하는 경우
    if(len(arr) == 0):
        # print('len(arr)==0 -> start : ', start, ' cnt : ', cnt)
        # print()
        return cnt
    end = -1
    for a in arr:
        if(start <= a[0]):
            new_arr.remove([a[0], a[1]])
            end = a[1]
            break
    if(end == -1):
        # print('end -> start : ', start, ' cnt : ', cnt)
        # print()
        return cnt
    x = conference(new_arr, end, cnt+1)

    # 해당 회의를 진행하지 않는 경우
    y = conference(new_arr, start, cnt)
    # print('start : ', start, 'x : ', x, ' y : ', y)
    return max(x, y)


x = conference(a, 0, 0)
print(x)
