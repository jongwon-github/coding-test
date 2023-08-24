import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CdTest0708V1 {
    int[] dir = {1, -1, 5};
    int[] chk = new int[10001];

    public int solution(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            queue.offer(n + dir[i]);
            chk[n + dir[i]] = 1;
        }
        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int pos = queue.poll();
                if (pos == m) return cnt;
                for (int i = 0; i < 3; i++) {
                    if (pos + dir[i] >= 1 && pos + dir[i] <= 10000 && chk[pos + dir[i]] == 0)
                    queue.offer(pos + dir[i]);
                }
                size--;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        CdTest0708V1 T = new CdTest0708V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        System.out.println(T.solution(n, m));
    }
}
