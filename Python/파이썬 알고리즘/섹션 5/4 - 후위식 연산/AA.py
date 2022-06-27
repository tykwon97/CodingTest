import sys
sys.stdin = open('input.txt', 'rt')
arr = list(input())

stack = []
for x in arr:
    if(x == '+' or x == '-' or x == '*' or x == '/'):
        y = int(stack.pop())
        z = int(stack.pop())
        if(x == '+'):
            stack.append(z+y)
        if(x == '-'):
            stack.append(z-y)
        if(x == '*'):
            stack.append(z*y)
        if(x == '/'):
            stack.append(z/y)
    else:
        stack.append(x)

    print(stack)

print(stack.pop())
