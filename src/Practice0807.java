import java.util.*;

public class Practice0807 {
    int[][] dy = new int[35][35];

    public int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        else if (n == r || r == 0) return 1;
        else return dy[n][r] = DFS(n - 1, r) + DFS(n - 1, r - 1);
    }

    public static void main(String[] args) {
        Practice0807 T = new Practice0807();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
