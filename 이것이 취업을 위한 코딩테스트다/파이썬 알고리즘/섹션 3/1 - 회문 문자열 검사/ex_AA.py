import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
for i in range(n):
    s = input()
    s = s.upper()

    # 짧지만 좋은 코드는 아니다.
    if (s == s[::-1]):  # s[::-1] reverse 시켜주는 코드
        print('#%d YES' % (i+1))
    else:
        print('#%d NO' % (i+1))

    # size = len(s)
    # for j in range(size//2):
    #     if(s[j] != s[-1-j]):
    #         print('#%d NO' % (i+1))
    #         break
    # else:
    #     print('#%d YES' % (i+1))
