import java.util.Scanner;

public class CdTest0706V1 {
    public void DFS(int L, int n, int[] arr) {
        if (L == n) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != 0) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            arr[n] = 1;
            DFS(L, n + 1, arr);
            arr[n] = 0;
            DFS(L, n + 1, arr);
        }
    }

    public static void main(String[] args) {
        CdTest0706V1 T = new CdTest0706V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n + 1];
        // 부분집합이라...어떻게 해야 되지???
        T.DFS(n + 1, 1, arr);
    }
}

