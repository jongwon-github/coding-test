import java.util.Scanner;

public class Real0807 {
    static int[][] arr;

    public int DFS(int n, int m) {
        if (arr[n][m] > 0) return arr[n][m];
        if (n == m || m == 0) return 1;
        else return arr[n][m] = DFS(n - 1, m - 1) + DFS(n - 1, m);
    }

    public static void main(String[] args) {
        Real0807 T = new Real0807();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        arr = new int[n + 1][n + 1];
        System.out.println(T.DFS(n, m));
    }
}
