# gift를 입력 순서대로 박스를 정해야되는데
# heap을 사용해서 크기가 큰 순으로 잘못 품

import heapq as hq
n, m = map(int, input().split())

b = list(map(int, input().split()))
gift = list(map(int, input().split()))

box = []
for x in b:
    hq.heappush(box, -x)

flag = True
while(gift):
    b = -hq.heappop(box)
    g = gift.pop(0)
    if(b >= g):
        if(b != g):
            hq.heappush(box, -(b-g))
    else:
        flag = False
        break

if(flag):
    print(1)
else:
    print(0)
