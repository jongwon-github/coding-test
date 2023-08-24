import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RealTime implements Comparable<RealTime> {
    int s, e;

    RealTime(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(RealTime o) {
        if (this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}

public class Real0902 {
    public int solution(List<RealTime> list) {
        int cnt = 0, startTime = 0;
        for (RealTime rt : list) {
            if (rt.s >= startTime) {
                cnt++;
                startTime = rt.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Real0902 T = new Real0902();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<RealTime> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            list.add(new RealTime(s, e));
        }
        Collections.sort(list);
        System.out.println(T.solution(list));
    }
}
