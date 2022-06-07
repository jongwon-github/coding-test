import java.util.Arrays;
import java.util.Scanner;

public class Practice0605 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        // 배열값을 정렬할 수 있는 방법
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice0605 T = new Practice0605();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
