n = int(input())


for _ in range(n):
    stack = []
    userInput = input()
    for x in userInput:
        if(x == '('):
            stack.append(x)
        else:
            if(len(stack) == 0):
                print("NO")
                break
            stack.pop()
    else:
        if(len(stack) == 0):
            print("YES")
        else:
            print("NO")
