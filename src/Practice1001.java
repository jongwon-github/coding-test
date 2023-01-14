import java.util.Scanner;

public class Practice1001 {
    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <=n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Practice1001 T = new Practice1001();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(T.solution(n));
    }
}
