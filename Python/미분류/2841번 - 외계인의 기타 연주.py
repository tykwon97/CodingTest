fret1 = []
fret2 = []
fret3 = []
fret4 = []
fret5 = []
fret6 = []

n, p = map(int, input().split())
count = 0

for _ in range(n):
    num, fret = map(int, input().split())
    if(num == 1):
        if(len(fret1) == 0):
            fret1.append(fret)
        else:
            while(len(fret1) != 0 and fret1[-1] > fret):
                fret1.pop()
                count += 1
            if(len(fret1) != 0 and fret1[-1] == fret):
                continue
            fret1.append(fret)
        count += 1

    elif(num == 2):
        if(len(fret2) == 0):
            fret2.append(fret)
        else:
            while(len(fret2) != 0 and fret2[-1] > fret):
                fret2.pop()
                count += 1
            if(len(fret2) != 0 and fret2[-1] == fret):
                continue
            fret2.append(fret)
        count += 1

    elif(num == 3):
        if(len(fret3) == 0):
            fret3.append(fret)
        else:
            while(len(fret3) != 0 and fret3[-1] > fret):
                fret3.pop()
                count += 1
            if(len(fret3) != 0 and fret3[-1] == fret):
                continue
            fret3.append(fret)
        count += 1

    elif(num == 4):
        if(len(fret4) == 0):
            fret4.append(fret)
        else:
            while(len(fret4) != 0 and fret4[-1] > fret):
                fret4.pop()
                count += 1
            if(len(fret4) != 0 and fret4[-1] == fret):
                continue
            fret4.append(fret)
        count += 1

    elif(num == 5):
        if(len(fret5) == 0):
            fret5.append(fret)
        else:
            while(len(fret5) != 0 and fret5[-1] > fret):
                fret5.pop()
                count += 1
            if(len(fret5) != 0 and fret5[-1] == fret):
                continue
            fret5.append(fret)
        count += 1

    elif(num == 6):
        if(len(fret6) == 0):
            fret6.append(fret)
        else:
            while(len(fret6) != 0 and fret6[-1] > fret):
                fret6.pop()
                count += 1
            if(len(fret6) != 0 and fret6[-1] == fret):
                continue
            fret6.append(fret)
        count += 1
print(count)
