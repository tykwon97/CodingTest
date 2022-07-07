import heapq as hq

n = int(input())
x = int(input())

people = []

if(n > 1):
    for _ in range(n-1):
        vote = int(input())
        if(x <= vote):
            hq.heappush(people, -vote)

count = 0
while(people):
    vote_x = -hq.heappop(people)
    if(vote_x >= x):
        hq.heappush(people, -(vote_x-1))
        x += 1
        count += 1
    else:
        break

print(count)
