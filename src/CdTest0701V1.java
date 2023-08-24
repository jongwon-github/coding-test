import java.util.Scanner;

public class CdTest0701V1 {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        CdTest0701V1 T = new CdTest0701V1();
        Scanner kb = new Scanner(System.in);
        // DFS(경로탐색) : stack???, BFS(최단경로) : queue???
        int n = kb.nextInt();
        T.DFS(n);
    }
}
