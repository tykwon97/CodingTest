import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
meeting = []
for i in range(n):
    s, e = map(int, input().split())
    meeting.append((s, e))

meeting.sort(key=lambda x: (x[1], x[0]))
# sort할 key값 정하기 x[1] x[0] 순으로 정렬
# 끝나는 시간이 같을 경우이다.
# 끝나는 시간이 같다면 빨리 시작하는 순서대로 정렬이 되어야 한다.


et = 0  # end time
cnt = 0

for s, e in meeting:
    if(s >= et):
        et = e
        cnt += 1

print(cnt)
