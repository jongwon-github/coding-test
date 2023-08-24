import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CdTest0713V1 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int n = queue.poll();
                ArrayList<Integer> arList = graph.get(n);
                for (int j = 0; j < arList.size(); j++) {
                    int m = arList.get(j);
                    if (ch[m] == 0) {
                        ch[m] = 1;
                        queue.offer(m);
                        dis[m] = dis[n] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        CdTest0713V1 T = new CdTest0713V1();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        ch[1] = 1;
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS();
//        for (int i = 2; i < dis.length; i++) {
//            System.out.println(i + " : " + dis[i]);
//        }
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
