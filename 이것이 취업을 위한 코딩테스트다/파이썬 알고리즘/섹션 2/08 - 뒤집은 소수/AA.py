import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
arr = list(map(str, input().split()))


def reverse(x):
    new_arr = []
    for v in x:
        new_v = ''
        for i in range(len(v)-1, -1, -1):
            new_v += v[i]
        new_arr.append(int(new_v))
    print(new_arr)
    return new_arr


def isPrime(x):
    primeList = ''
    for v in x:
        if(v == 1):
            continue
        for i in range(2, v):
            if(v % i == 0):
                break
        else:
            primeList += str(v) + ' '
    print(primeList)


arr = reverse(arr)
isPrime(arr)
