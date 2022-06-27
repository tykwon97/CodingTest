import sys
sys.stdin = open('input.txt', 'rt')
a = list(range(21))  # 자동으로 0부터 20까지의 list 생성됨
for _ in range(10):
    s, e = map(int, input().split())
    for i in range((e-s+1)//2):  # +1은 홀수일때까지 생각
        a[s+i], a[e-i] = a[e-i], a[s+i]
# .pop() 제일 뒷부분이 나옴
a.pop(0)  # 0을 적어주는 경우 제일 앞부분이 나옴
for x in a:
    print(x, end=' ')
