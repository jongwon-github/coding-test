import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        // time을 기준으로 내림차순정렬
        return o.time - this.time;
    }
}

public class Practice0904 {
    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        // 큰값을 우선 순위로 꺼내기 위해서 Collections.reverseOrder() 추가
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0904 T = new Practice0904();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if (d > max) max = d;
        }
        System.out.println(T.solution(arr));
    }
}
