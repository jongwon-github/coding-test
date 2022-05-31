import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Practice0508 {
    public String solution(int n, int m, int[] arr) {
        String answer = "";
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person x : queue) {
                if (x.priority > tmp.priority) {
                    queue.offer(x);
                    tmp = null;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0508 T = new Practice0508();
        Scanner kb = new Scanner(System.in);
    }
}
