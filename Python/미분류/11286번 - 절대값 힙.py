import heapq

# 빠른 입출력 차이가 크다!!
import sys
input = sys.stdin.readline

n = int(input())

queue = []
num_list = dict()

for _ in range(n):
    num = int(input())

    if(num == 0):
        if(queue):
            x = heapq.heappop(queue)
            if(num_list.get(-x) != None and num_list.get(-x) > 0):
                num_list[-x] -= 1
                print(-x)
                continue
            else:
                num_list[x] -= 1
                print(x)
        else:
            print("0")

    else:
        heapq.heappush(queue, abs(num))
        if(num_list.get(num) == None):
            num_list[num] = 1
        else:
            num_list[num] += 1
