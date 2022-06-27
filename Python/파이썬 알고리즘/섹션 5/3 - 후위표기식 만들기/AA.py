import sys
sys.stdin = open('input.txt', 'rt')
arr = list(input())

priority = {'(': 1, '/': 1, '*': 1, '+': 0, '-': 0}

result = ''
stack = []
new = []
for x in arr:
    # print('x: ', x)
    if(x == '+' or x == '-' or x == '*' or x == '/'):
        if(len(stack) != 0):
            # print(priority[x], priority[stack[-1]])
            if(priority[x] <= priority[stack[-1]] and stack[-1] != '('):  # stack의 우선순위가 높거나 같은 경우
                # if(priority[x] == priority[stack[-1]]):
                while(stack):
                    if(stack[-1] == '('):
                        break
                    result += stack.pop()
                stack.append(x)
                # else:
                # result += x
            else:
                stack.append(x)
        else:
            stack.append(x)
    elif(x == '('):
        stack.append(x)

    elif(x == ')'):
        y = ''
        while(y != '('):
            y = stack.pop()
            if(y == '('):
                continue
            result += y
    else:  # 숫자
        result += x

    # print(result)
    # print(stack)
    # print()

while(stack):
    result += stack.pop()

print(result)
