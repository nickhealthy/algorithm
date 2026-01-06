import sys
import heapq

input = sys.stdin.readline
n = int(input())

hq = []
for _ in range(n):
    cmd = int(input())

    if not hq and cmd == 0:
        print(0)

    elif cmd == 0:
        print(heapq.heappop(hq)[1])

    else:
        heapq.heappush(hq, (-cmd, cmd))
