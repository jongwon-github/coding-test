import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RealBody implements Comparable<RealBody> {
    int h, w;

    RealBody(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(RealBody o) {
        return o.h - this.h;
    }
}

public class Real0901 {
    public int solution(List<RealBody> list) {
        int maxWeight = 0, answer = 0;
        for (RealBody rb : list) {
            if (rb.w > maxWeight) {
                answer++;
                maxWeight = rb.w;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Real0901 T = new Real0901();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<RealBody> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            list.add(new RealBody(h, w));
        }
        Collections.sort(list);
        System.out.println(T.solution(list));
    }
}
