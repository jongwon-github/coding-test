import java.util.*;

public class Practice0806 {
    static int[] pm, ch, test;
    static int n, m;

    public void DFS(int L) {
        if (L == m) {
            if (test.length == 2) {
                for (int x : test) System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    test[L] = pm[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Practice0806 T = new Practice0806();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[n];
        for (int i = 0; i < n; i++) pm[i] = kb.nextInt();
        ch = new int[n];
        test = new int[m];
        T.DFS(0);
    }
}