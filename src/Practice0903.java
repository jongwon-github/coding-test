import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time0903 implements Comparable<Time0903> {
    public int time;
    public char state;

    public Time0903(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time0903 o) {
        if (this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}

public class Practice0903 {
    public int solution(ArrayList<Time0903> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time0903 ob : arr) {
            if (ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args) {
        Practice0903 T = new Practice0903();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time0903> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time0903(sT, 's'));
            arr.add(new Time0903(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
