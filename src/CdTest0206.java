import java.util.*;

class Info implements Comparable<Info> {
    String name;
    int time;

    Info(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(Info o) {
        /**
         * time 오름차순정렬
         * 메서드를 호출하는 객체가 인자로 넘어온 객체보다 작을 경우에는 음수, 크기가 동일하다면 0, 클 경우에는 양수를 리턴 해야 함
         */
        return this.time - o.time;
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
        ArrayList<Info> infoList = new ArrayList<>();
        for (String report : reports) {
            String name = report.split(" ")[0];
            infoList.add(new Info(name, getTime(report.split(" ")[1])));
        }
        Collections.sort(infoList);
        ArrayList<String> nameList = new ArrayList<>();
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        for (Info info : infoList) {
            if (info.time >= s && info.time <= e) nameList.add(info.name);
            if (info.time > e) break;
        }
        String[] answer = new String[nameList.size()];
        for(int i = 0; i < nameList.size(); i++){
            answer[i] = nameList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0206 T = new CdTest0206();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
