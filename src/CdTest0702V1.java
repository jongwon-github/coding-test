import java.util.Scanner;

public class CdTest0702V1 {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main(String[] args) {
        CdTest0702V1 T = new CdTest0702V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.DFS(n);
    }
}
