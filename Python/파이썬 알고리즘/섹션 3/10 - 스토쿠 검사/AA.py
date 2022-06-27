import sys
sys.stdin = open('input.txt', 'rt')
arr = []
for _ in range(9):
    arr.append(list(map(int, input().split())))

check = True
for i in range(9):
    rowCheck = set()
    columnCheck = set()

    for j in range(9):
        rowCheck.add(arr[i][j])
        columnCheck.add(arr[j][i])
    if(len(rowCheck) != 9 and len(columnCheck) != 9):
        check = False
        break

for i in range(3):
    for j in range(3):
        x = i*3
        y = j*3
        boxCheck = set()
        for n in range(3):
            for m in range(3):
                boxCheck.add(arr[x+n][y+m])
        if(len(boxCheck) != 9):
            check = False
            break

if(check == True):
    print('YES')
else:
    print('NO')
