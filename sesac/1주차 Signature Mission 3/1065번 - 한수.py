n = int(input())

count = 0

for i in range(1, n+1):
    # print(f'i : {i} ')
    arr = []
    arr.append(i % 10)
    i //= 10

    while(i > 0):
        arr.append(i % 10)
        i //= 10

    flag = True
    if(len(arr) > 1):
        temp = arr[1] - arr[0]
        for j in range(len(arr)-1):
            # print(f'temp : {temp}')
            if(temp != (arr[j+1] - arr[j])):
                flag = False
                break
    if(flag == True):
        count += 1

print(count)
