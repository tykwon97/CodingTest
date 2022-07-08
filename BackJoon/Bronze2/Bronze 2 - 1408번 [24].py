arr = input()
start_hour, start_min, start_sec = int(
    arr[0]+arr[1]), int(arr[3]+arr[4]), int(arr[6]+arr[7])
arr = input()
end_hour, end_min, end_sec = int(
    arr[0]+arr[1]), int(arr[3]+arr[4]), int(arr[6]+arr[7])

start = start_hour*60*60 + start_min*60 + start_sec
end = end_hour*60*60 + end_min*60 + end_sec

time = end-start
if(time < 0):
    time = 24*60*60-start+end
h = time//60 // 60
m = time//60 % 60
s = time % 60

if(h < 10):
    h = '0'+str(h)
if(m < 10):
    m = '0'+str(m)
if(s < 10):
    s = '0'+str(s)

print(h, ':', m, ':', s, sep="")