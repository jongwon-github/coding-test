import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class RealEdge implements Comparable<RealEdge> {
    int e, dis;

    RealEdge(int e, int dis) {
        this.e = e;
        this.dis = dis;
    }

    @Override
    public int compareTo(RealEdge o) {
        return this.dis - o.dis;
    }
}

public class Real0905 {
    static int[] dis;
    static ArrayList<ArrayList<RealEdge>> list;

    public void solution() {
        PriorityQueue<RealEdge> pQ = new PriorityQueue<>();
        pQ.offer(new RealEdge(1, 0));
        while (!pQ.isEmpty()) {
            RealEdge tmp = pQ.poll();
            int now = tmp.e;
            int nowCost = tmp.dis;
            // 여기가 중요함!!!

            for (RealEdge re : list.get(now)) {
                if (dis[re.e] > nowCost + re.dis) {
                    dis[re.e] = nowCost + re.dis;
                    pQ.offer(new RealEdge(re.e, nowCost + re.dis));
                }
            }
        }
    }

    public static void main(String[] args) {
        Real0905 T = new Real0905();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            int dis = kb.nextInt();
            list.get(s).add(new RealEdge(e, dis));
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        T.solution();
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
