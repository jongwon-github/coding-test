import java.util.Scanner;

public class Practice0702 {
    public void DFS(int n) {
       if (n == 0) return;
       else {
           DFS(n / 2);
           System.out.print(n % 2);
       }
    }

    public static void main(String[] args) {
        Practice0702 T = new Practice0702();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.DFS(n);
    }
}