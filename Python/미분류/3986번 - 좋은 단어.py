n = int(input())
cnt = 0

for _ in range(n):
    str = input()
    stack = []
    for i in range(len(str)):
        if(stack):
            if(stack[-1] == str[i]):
                stack.pop()
            else:
                stack.append(str[i])
        else:
            stack.append(str[i])
    if(len(stack) == 0):
        cnt += 1
print(cnt)
