class Solution {

    public Integer makeSeconds(String time) {
        String[] split = time.split(":");
        int minutes = Integer.valueOf(split[0]);
        int seconds = Integer.valueOf(split[1]);

        return minutes * 60 + seconds;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        Integer videoLenSec = makeSeconds(video_len);
        Integer posSec = makeSeconds(pos);
        Integer opStartSec = makeSeconds(op_start);
        Integer opEndSec = makeSeconds(op_end);

        for (String command : commands) {
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }

            if (command.equals("prev")) {
                posSec = Math.max(0, posSec - 10);
            } else {
                posSec = Math.min(videoLenSec, posSec + 10);
            }
        }
        
        if (opStartSec <= posSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }

        int m = posSec / 60,
            s = posSec % 60;

        return new StringBuilder().append(m < 10 ? "0" + m : m + "").append(":").append(s < 10 ? "0" + s : s + "").toString();

    }

    
}