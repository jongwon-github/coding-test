import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RealTime0903 implements Comparable<RealTime0903> {
    int t;
    char c;

    RealTime0903(int t, char c) {
        this.t = t;
        this.c = c;
    }

    @Override
    public int compareTo(RealTime0903 o) {
        if (this.t == o.t) return this.c - o.c;
        else return this.t - o.t;
    }
}

public class Real0903 {
    public int solution(List<RealTime0903> arr) {
        int max = 0, cnt = 0;
        for (RealTime0903 rt : arr) {
            if (rt.c == 's') cnt++;
            else if (rt.c == 'e') cnt--;
            if (max < cnt) max = cnt;
        }
        return max;
    }

    public static void main(String[] args) {
        Real0903 T = new Real0903();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<RealTime0903> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new RealTime0903(sT, 's'));
            arr.add(new RealTime0903(eT, 'e'));
        }
        Collections.sort(arr);
        System.out.println(T.solution(arr));
    }
}
