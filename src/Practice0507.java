import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice0507 {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) queue.offer(x);
        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if (x != queue.poll()) return "NO";
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0507 T = new Practice0507();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        T.solution(a, b);
    }
}
