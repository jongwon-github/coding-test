import java.util.Scanner;

public class CdTest0802V1 {
    static int w, n;
    static int[] arrWeight;
    static int tempWeight = Integer.MIN_VALUE;

    public void DFS(int L, int sum) {
        if (sum > w) return;
        if (L == n) {
            if (sum > tempWeight) tempWeight = sum;
        } else {
            DFS(L + 1, sum);
            DFS(L + 1, sum + arrWeight[L]);
        }
    }

    public static void main(String[] args) {
        CdTest0802V1 T = new CdTest0802V1();
        Scanner kb = new Scanner(System.in);
        w = kb.nextInt();
        n = kb.nextInt();
        arrWeight = new int[n];
        for (int i = 0; i < n; i++) {
            arrWeight[i] = kb.nextInt();
        }
        T.DFS(0, 0);
        System.out.println(tempWeight);
    }
}
