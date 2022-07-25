import java.util.Scanner;

public class Practice0804 {
    static int[] pm;
    static int n, m;

    public void DFS(int L) {
        if (L == m) System.out.println("다 돌았다!");
        else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Practice0804 T = new Practice0804();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
