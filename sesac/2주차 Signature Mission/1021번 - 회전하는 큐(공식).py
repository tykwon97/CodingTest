n, m = map(int, input().split())

count = 0

index = list(map(int, input().split()))

for i in range(m):
    if(n % 2 == 1):
        num = n//2 + 1 + 0.5
    else:
        num = n//2 + 1

    if(index[i] > num):
        count += n-index[i]+1
        for j in range(i+1, m):
            # print('1n : ', n, 'index[j] : ', index[j], 'index[i] : ', index[i],
            #   index[i], 'index[j]+n-index[i] : ', index[j]+n-index[i])
            if(index[j]+index[i] > n):
                index[j] = (index[j]-index[i]+n) % n
            else:
                index[j] += (n-index[i])
        n -= 1
        # print("what")
    else:
        count += index[i] - 1
        for j in range(i+1, m):
            # print('2n : ', n, 'index[j] : ', index[j], 'index[i] : ',
            #   index[i], 'index[j]-index[i] : ', index[j]-index[i])

            if(index[j] - index[i] < 1):
                index[j] -= (index[i])-n
            else:
                index[j] -= (index[i])
        n -= 1
    # print(*index)
    # print(count)

print(count)
