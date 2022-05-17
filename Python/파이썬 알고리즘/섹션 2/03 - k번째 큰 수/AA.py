from itertools import *

import sys
sys.stdin = open('input.txt', 'rt')
n, k = map(int, input().split())
arr = list(map(int, input().split()))

sum_list = list(combinations(arr, 3))
sum_list = list(map(lambda x: int(sum(x)), sum_list))
sum_list = list(set(sum_list))
sum_list.sort(reverse=True)
print(sum_list[k-1])
