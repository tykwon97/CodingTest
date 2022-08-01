import sys
sys.stdin = open('input.txt', 'rt')
n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))

# 오래 걸리는 방법
arr = n_list + m_list
arr.sort()
for x in arr:
    print(x, end=' ')
print()

# 다른 방법
arr = list()
for i in range(n+m):
    if(0 != len(n_list) and 0 != len(m_list)):
        if(n_list[0] < m_list[0]):
            x = n_list.pop(0)
        else:
            x = m_list.pop(0)
        arr.append(x)
    else:
        if(len(n_list) == 0):
            arr += m_list
        else:
            arr += n_list
        break
for x in arr:
    print(x, end=' ')
