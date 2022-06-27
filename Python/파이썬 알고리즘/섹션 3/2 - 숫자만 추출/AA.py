import sys
sys.stdin = open('input.txt', 'rt')
s = input()
num = ''
for x in s:
    if(48 <= ord(x) <= 57):  # 48~57
        num += x
num = int(num)
cnt = 0  # 약수의 개수
for i in range(1, num+1):
    if(num % i == 0):
        cnt += 1

print(num)
print(cnt)
