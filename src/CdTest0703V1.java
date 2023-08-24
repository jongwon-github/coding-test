import java.util.Scanner;

public class CdTest0703V1 {
    public int DFS(int n) {
        if (n == 1) return n;
        else return n * DFS(n - 1);
    }

    public static void main(String[] args) {
        CdTest0703V1 T = new CdTest0703V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.DFS(n));
    }
}
