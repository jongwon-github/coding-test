import java.util.Scanner;

public class CdTest0704V1 {
    static int[] arr;
    public int DFS(int n) {
        if (arr[n] > 0) return arr[n];
        if (n == 1 || n == 2) return arr[n] = 1;
        else return arr[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        CdTest0704V1 T = new CdTest0704V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        arr = new int[n + 1];
        T.DFS(n);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}