import java.util.Scanner;

public class Real1006 {
    public void solution() {

    }

    public static void main(String[] args) {
        Real1006 T = new Real1006();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int score = kb.nextInt();
            int time = kb.nextInt();
            for (int j = m; j >= time; j--) {
                if (dy[j] < dy[j - time] + score) dy[j] = dy[j - time] + score;
            }
        }
        System.out.println(dy[m]);
    }
}
