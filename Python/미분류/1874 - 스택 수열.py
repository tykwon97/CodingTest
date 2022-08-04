n = int(input())
stack = []
index = 1

result = []

for j in range(n):
    x = int(input())
    if(index <= x):
        for i in range(x-index+1):
            stack.append(index)
            index += 1
            result.append("+")
        result.append("-")
        y = stack.pop()
    else:
        result.append("-")
        y = stack.pop()
        if(x != y):
            result.clear()
            result.append("NO")
            break

for x in result:
    print(x)
