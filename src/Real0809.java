import java.util.Scanner;

public class Real0809 {
    static int[] arr;

    public void DFS(int L, int sum, int n1, int n2) {
        if (L == n2) {
            for (int n : arr) System.out.print(n + " ");
            System.out.println();
        } else {
            for (int i = sum + 1; i <= n1; i++) {
                arr[L] = i;
                DFS(L + 1, i, n1, n2);
            }
        }
    }

    public static void main(String[] args) {
        Real0809 T = new Real0809();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        arr = new int[m];
        T.DFS(0, 0, n, m);
    }
}
