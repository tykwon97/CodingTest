# CodingTest
Python - 이것이 코딩 테스트다 with Python     
Python - 파이썬 알고리즘(인프런 코딩테스트 강의)  
  
Library - 함수 라이브러리 모음    
  
라이브러리 함수 작성 예시  
  
js - 자바스크립트(프로그래머스)  
  
```
# 2차원 리스트(행렬)를 90도 회전하는 메소드  
def rotate_a_matrix_by_90_degree(a):
  row_length = len(a)
  column_length = len(a[0])

  res = [[0] * row_length for _ in range(column_length)]
  for r in range(row_length):
    for c in range(column_length):
      res[c][row_length - 1 - r ] = a[r][c]
  return res
  
#사용 예시

a = [
      [1,2,3,4],
      [5,6,7,8],
      [9,10,11,12]
]

print(rotate_a_matrix_by_90_degree(a))

```
