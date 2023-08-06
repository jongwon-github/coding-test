import java.util.*;

class Report implements Comparable<Report> {
    String name;
    int hour, minute;

    Report (String name, int hour, int minute) {
        this.name = name;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Report o) {
        // hour, minute 오름차순정렬
        // 왜 -1을 return 하지?
        if (this.hour > o.hour) return this.hour - o.hour;
        else if (this.hour == o.hour) return this.minute - o.minute;
        return -1;
    }
}

public class CdTest0206 {
    /**
     * 시간 정보를 분으로 환산하는 메소드
     * 이 부분이 포인트 인거 같음
     * 시간을 분으로 환산하면 시간을 비교하기가 쉬워짐
     */
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }

    public String[] solution(String[] reports, String times){
        String[] answer = {};
        List<Report> rList = new ArrayList<>();
        int i = 0;
        for (String report : reports) {
            Report r = new Report(report.split(" ")[0], Integer.parseInt(report.split(" ")[1].split(":")[0]), Integer.parseInt(report.split(" ")[1].split(":")[1]));
            rList.add(i++, r);
        }
        Collections.sort(rList);
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        ArrayList<String> nList = new ArrayList<>();
        for (Report r : rList) {
            int time = getTime(String.valueOf(r.hour) + String.valueOf(r.minute));
            if (time >= s && time <= e) {
                nList.add(r.name);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0206 T = new CdTest0206();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        //System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        //System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
