import heapq

n = int(input())
gift = []

for _ in range(n):
    num = input()
    if(num == "0"):
        if(len(gift) == 0):
            print("-1")
        else:
            print(-heapq.heappop(gift))
    else:
        gift_list = list(map(int, num.split()))
        for i in range(1, len(gift_list)):
            heapq.heappush(gift, -gift_list[i])
