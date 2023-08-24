import java.util.Scanner;

public class CdTest0703 {
    public int DFS(int L) {
        if (L == 1) {
            return 1;
        } else {
            return L * DFS(L - 1);
        }
    }

    public static void main(String[] args) {
        CdTest0703 T = new CdTest0703();
        Scanner kb = new Scanner(System.in);
        System.out.println(T.DFS(5));
    }
}
