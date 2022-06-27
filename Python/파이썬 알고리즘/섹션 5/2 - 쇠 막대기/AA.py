import sys
sys.stdin = open('input.txt', 'rt')
arr = list(input())

# stack 사용한 방법
stack = []
tot = 0
value = ''

for i, x in enumerate(arr):
    if(arr[i] == '('):
        stack.append('(')
    else:
        stack.pop()
        if(value == '('):
            tot += len(stack)
        else:
            tot += 1
    value = x


# cnt = 0
# tot = 0

# for i, x in enumerate(arr):
#     if(arr[i] == '('):
#         cnt += 1
#     else:
#         if(arr[i-1] == '('):
#             cnt -= 1
#             tot += cnt
#             continue
#         else:
#             cnt -= 1
#             tot += 1

print(tot)
