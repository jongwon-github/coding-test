import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice0506 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.offer(i);
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) queue.offer(queue.poll());
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        /* queue를 사용하는 문제(FIFO) */
        Practice0506 T = new Practice0506();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(T.solution(n, k));
    }
}
