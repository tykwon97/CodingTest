import sys
sys.stdin = open('input.txt', 'rt')
# 더하기 하는 방식이 아닌 1로 대체 하는 방식을 사용해서 sum을 사용할 수 있도록 함!!!!!


def check(a):
    for i in range(9):
        ch1 = [0]*10
        ch2 = [0]*10
        for j in range(9):
            ch1[a[i][j]] = 1
            ch2[a[j][i]] = 1
        if(sum(ch1) != 9 or sum(ch2) != 9):
            return False

    for i in range(3):
        for j in range(3):
            ch3 = [0]*10
            for k in range(3):
                for s in range(3):
                    ch3[a[i*3+k][j*3+s]] = 1
            if(sum(ch3) != 9):
                False

    return True


a = [list(map(int, input().split())) for _ in range(9)]
if check(a):
    print("YES")
else:
    print("NO")
