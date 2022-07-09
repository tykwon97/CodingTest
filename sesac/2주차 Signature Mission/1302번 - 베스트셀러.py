n = int(input())
book = dict()

for _ in range(n):
    name = input()
    if(name in book):
        book[name] += 1
    else:
        book[name] = 1

maxCount = 0
result = []
for x in book.items():
    bookName = x[0]
    bookCount = x[1]
    if(bookCount > maxCount):
        maxCount = bookCount
        result = []
        result.append(bookName)
    elif(bookCount == maxCount):
        result.append(bookName)

print(sorted(result)[0])
