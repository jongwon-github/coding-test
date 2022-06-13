import java.util.Arrays;
import java.util.Scanner;

public class Practice0608 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0, rt = n - 1;
        Arrays.sort(arr);
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] > m) rt = mid - 1;
            else if (arr[mid] == m) {
                answer = mid + 1;
                break;
            } else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0608 T = new Practice0608();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
