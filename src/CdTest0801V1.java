import java.awt.image.BandedSampleModel;
import java.util.Arrays;
import java.util.Scanner;

public class CdTest0801V1 {
    static int[] arrNum;
    static int totalSum;
    boolean flag = false;
    static String answer = "NO";

    public void DFS(int L, int sum) {
        if (flag) return;
        if (sum > (totalSum / 2)) return;
        if (L == 6) {
            if (totalSum == sum * 2) {
                flag = true;
                answer = "YES";
            }
        } else {
            DFS(L + 1, sum);
            DFS(L + 1, sum + arrNum[L]);
        }
    }

    public static void main(String[] args) {
        CdTest0801V1 T = new CdTest0801V1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        arrNum = new int[n];
        for (int i = 0; i < n; i++) {
            arrNum[i] = kb.nextInt();
        }
        totalSum = Arrays.stream(arrNum).sum();
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
