n = int(input())

result = 0

for i in range(1, n+1):
    str_i = str(i)
    for x in str_i:
        if(x == "3" or x == "6" or x == "9"):
            result += 1

print(result)
