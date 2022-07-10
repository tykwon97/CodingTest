n = int(input())
postfix = list(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

for i in range(len(postfix)):
    if(postfix[i] != "+" and postfix[i] != "-" and postfix[i] != "*" and postfix[i] != "/"):
        postfix[i] = arr[ord(postfix[i]) - ord('A')]

stack = []
for x in postfix:
    if(x == "+"):
        b = stack.pop()
        a = stack.pop()
        stack.append(a+b)
    elif(x == "-"):
        b = stack.pop()
        a = stack.pop()
        stack.append(a-b)
    elif(x == "*"):
        b = stack.pop()
        a = stack.pop()
        stack.append(a*b)
    elif(x == "/"):
        b = stack.pop()
        a = stack.pop()
        stack.append(a/b)
    else:
        stack.append(x)
    # print(stack)

print(f'{stack.pop():.2f}')
