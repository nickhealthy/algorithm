def solution(video_len, pos, op_start, op_end, commands):

    video_total_second = makeSeconds(video_len)
    pos_total_second = makeSeconds(pos)
    op_start_total_second = makeSeconds(op_start)
    op_end_total_second = makeSeconds(op_end)

    for cmd in commands:
        if op_start_total_second <= pos_total_second <= op_end_total_second:
                pos_total_second = op_end_total_second

        if cmd == "prev":
            # 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동
            if pos_total_second < 11 or video_total_second < 11:
                pos_total_second = 0
                continue

            pos_total_second -= 10

        elif cmd == "next":
            # 동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동
            if video_total_second - pos_total_second < 10:
                pos_total_second = video_total_second
                continue

            pos_total_second += 10

    # 오프닝 사이 시간 확인
    if op_start_total_second <= pos_total_second <= op_end_total_second:
        pos_total_second = op_end_total_second  

    return seconds_to_time_str(pos_total_second)
    

def makeSeconds(time: str) -> int:
    minutes, seconds = map(int, time.split(":"))
    total_second = minutes * 60 + seconds
    
    return total_second


def seconds_to_time_str(seconds):
    minutes, remaining_seconds = divmod(seconds, 60)
    return f"{minutes:02d}:{remaining_seconds:02d}"